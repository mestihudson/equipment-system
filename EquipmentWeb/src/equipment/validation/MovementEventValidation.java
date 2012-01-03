package equipment.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.dao.MovementEventDao;
import equipment.domain.entity.MovementEvent;
import equipment.validation.checks.AbstractValidationCheck;
import equipment.validation.checks.ContainerCheck;
import equipment.validation.checks.EventDateCheck;
import equipment.validation.checks.FacilityCheck;

@Service
@Scope("prototype")
public class MovementEventValidation extends EventValidationTemplate {

  @Autowired
  private MovementEventDao movementEventDao;

  @Override
  protected void initializeRules(List<AbstractValidationCheck> rules) {
    rules.add(new ContainerCheck());
    rules.add(new EventDateCheck());
    rules.add(new FacilityCheck());
  }

  @Override
  protected void addToEventLog() {
    MovementEvent event = validationEnvironment.createMovementEventLog();
    movementEventDao.save(event);
  }

  @Override
  protected void updateOrCreateEquipment() {
    // do nothing
  }
}
