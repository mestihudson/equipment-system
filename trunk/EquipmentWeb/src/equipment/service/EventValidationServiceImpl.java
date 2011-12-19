package equipment.service;

import org.springframework.stereotype.Service;

import equipment.domain.enums.ValidationType;
import equipment.validation.EquipmentEventValidation;
import equipment.validation.IEventValidation;
import equipment.validation.IncomingEquipmentEvent;
import equipment.validation.IncomingEvent;
import equipment.validation.IncomingMovementEvent;
import equipment.validation.MovementEventValidation;
import equipment.validation.ValidationResult;

@Service("eventValidationService")
public class EventValidationServiceImpl implements EventValidationService {
  IEventValidation eventValidation;
  
  @Override
  public ValidationResult validateEvent(IncomingEvent event, ValidationType validationType) {
    switch (validationType) {
    case NEW:
    case REVALIDATE:
    case EDIT:
      return new MovementEventValidation().validate(event, validationType);
    case CREATION:
    case TERMINATION:
      return new EquipmentEventValidation().validate(event, validationType);
    default:
      return null;
    }
  }
}
