package equipment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.dao.ContainerDao;
import equipment.dao.EquipmentEventDao;
import equipment.domain.entity.Container;
import equipment.domain.entity.EquipmentEvent;
import equipment.domain.enums.ValidationType;

@Service
@Scope("prototype")
public class EquipmentEventValidation extends EventValidationTemplate {
  @Autowired
  private ContainerDao containerDao;
  @Autowired
  private EquipmentEventDao equipmentEventDao;
  
  @Override
  protected void applyRules() {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addToEventLog() {
    EquipmentEvent event = validationEnvironment.createEquipmentEventLog();
    equipmentEventDao.save(event);
    
  }

  @Override
  protected void updateOrCreateEquipment() {
    if (validationEnvironment.getValidationType() == ValidationType.CREATION
        || validationEnvironment.getValidationType() == ValidationType.TERMINATION) {
      Container containerInfo = validationEnvironment.getContainerInfo();
      containerDao.saveOrUpdate(containerInfo);
    }
  }
}
