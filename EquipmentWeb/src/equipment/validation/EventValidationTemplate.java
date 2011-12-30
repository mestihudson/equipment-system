package equipment.validation;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import equipment.dao.EquipmentLatestInfoDao;
import equipment.dao.RejectionDao;
import equipment.domain.entity.EquipmentLatestInfo;
import equipment.domain.entity.Rejection;
import equipment.domain.enums.ValidationType;

public abstract class EventValidationTemplate {
  @Resource(name = "validationEnvironment")
  protected ValidationEnvironment validationEnvironment;
  @Resource(name = "rejectionDao")
  private RejectionDao rejectionDao;
  @Resource(name = "equipmentLatestInfoDao")
  private EquipmentLatestInfoDao equipmentLatestInfoDao;

  public ValidationResult validate(IncomingEvent event, ValidationType validationType) {
    validationEnvironment.initialize();
    validationEnvironment.setIncomingEvent(event);
    validationEnvironment.setValidationType(validationType);
    applyRules();
    processResults();
    return validationEnvironment.getValidationResult();
  }

  protected abstract void applyRules();

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
      if(latestInfo == null) {
        latestInfo = new EquipmentLatestInfo();
      }
      validationEnvironment.update(latestInfo);
      equipmentLatestInfoDao.saveOrUpdate(latestInfo);
    }
  }
  
  @PreDestroy
  public void destory(){
    System.out.println("------------------------->destory");
  }
}
