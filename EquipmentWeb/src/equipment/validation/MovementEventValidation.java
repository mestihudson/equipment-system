package equipment.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.dao.MovementEventDao;
import equipment.domain.entity.MovementEvent;
import equipment.validation.checks.AbstractValidationCheck;
import equipment.validation.checks.ContainerCheck;

@Service
@Scope("prototype")
public class MovementEventValidation extends EventValidationTemplate {

  @Autowired
  private MovementEventDao movementEventDao;
  
  @Override
  protected void applyRules() {
//    for(AbstractValidationCheck check : checkList) {
//      if(check.applyTo(validationEnvironment.getIncomingEvent(), validationEnvironment.getValidationType())) {
//        check.validate(validationEnvironment);
//      }
//    }
  }

  @Override
  protected void addToEventLog() {
    MovementEvent event = validationEnvironment.createMovementEventLog();
    movementEventDao.save(event);
  }

  @Override
  protected void updateOrCreateEquipment() {
    // TODO Auto-generated method stub
    
  }
}
