package equipment.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.domain.enums.ValidationType;
import equipment.validation.EquipmentEventValidation;
import equipment.validation.IncomingEvent;
import equipment.validation.MovementEventValidation;
import equipment.validation.ValidationResult;

@Service("eventValidationService")
@Transactional
@Scope("prototype")
public class EventValidationServiceImpl implements EventValidationService {
  @Resource(name = "movementEventValidation")
  private MovementEventValidation movementEventValidation;
  @Resource(name = "equipmentEventValidation")
  private EquipmentEventValidation equipmentEventValidation;

  @Override
  public ValidationResult validateEvent(IncomingEvent event, ValidationType validationType) {
    switch (validationType) {
    case NEW:
    case REVALIDATE:
      return movementEventValidation.validate(event, validationType, true);
    case EDIT:
      return movementEventValidation.validate(event, validationType, false);
    case CREATION:
    case TERMINATION:
      return equipmentEventValidation.validate(event, validationType, true);
    default:
      return null;
    }
  }
}
