package equipment.validation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import equipment.dao.EquipmentLatestInfoDao;
import equipment.dao.RejectionDao;
import equipment.domain.entity.EquipmentLatestInfo;
import equipment.domain.entity.Rejection;
import equipment.domain.enums.ValidationType;
import equipment.validation.checks.AbstractValidationCheck;

public abstract class EventValidationTemplate implements InitializingBean {
  @Resource(name = "validationEnvironment")
  protected ValidationEnvironment validationEnvironment;
  @Resource(name = "rejectionDao")
  private RejectionDao rejectionDao;
  @Resource(name = "equipmentLatestInfoDao")
  private EquipmentLatestInfoDao equipmentLatestInfoDao;

  private List<AbstractValidationCheck> rules;

  public ValidationResult validate(IncomingEvent event, ValidationType validationType, boolean needRepository) {
    validationEnvironment.initialize();
    validationEnvironment.setIncomingEvent(event);
    validationEnvironment.setValidationType(validationType);
    applyRules();
    if (needRepository) {
      processResults();
    }
    return validationEnvironment.getValidationResult();
  }

  protected abstract void initializeRules(List<AbstractValidationCheck> rules);

  private void applyRules() {
    for (AbstractValidationCheck check : rules) {
      if (check.applyTo(validationEnvironment.getIncomingEvent(), validationEnvironment.getValidationType())) {
        check.validate(validationEnvironment);
      }
    }
  }

  protected abstract void addToEventLog();

  protected abstract void updateOrCreateEquipment();

  protected void processResults() {
    ValidationResult result = validationEnvironment.getValidationResult();
    if (result.hasRejection()) {
      addToRejection();
    } else {
      updateOrCreateEquipment();
      addToEventLog();
      updateLatestInfo();
    }
  }

  protected void addToRejection() {
    Rejection rejection = validationEnvironment.createRejection();
    rejectionDao.save(rejection);
  }

  private void updateLatestInfo() {
    if (validationEnvironment.isCurrent()) {
      EquipmentLatestInfo latestInfo = equipmentLatestInfoDao.get(validationEnvironment.getIncomingEvent()
          .getEquipmentNumber());
      if (latestInfo == null) {
        latestInfo = new EquipmentLatestInfo();
      }
      validationEnvironment.update(latestInfo);
      equipmentLatestInfoDao.saveOrUpdate(latestInfo);
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    rules = new ArrayList<AbstractValidationCheck>();
    initializeRules(rules);
  }
}
