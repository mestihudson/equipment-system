package equipment.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import equipment.domain.enums.ValidationType;
import equipment.validation.EquipmentEventValidation;
import equipment.validation.EventValidationTemplate;
import equipment.validation.IncomingEvent;
import equipment.validation.MovementEventValidation;
import equipment.validation.ValidationResult;

@Service("eventValidationService")
public class EventValidationServiceImpl implements EventValidationService {
  EventValidationTemplate eventValidation;
  @Resource(name = "movementEventValidation")
  private MovementEventValidation movementEventValidation;
  @Resource(name = "equipmentEventValidation")
  private EquipmentEventValidation equipmentEventValidation;
  
  @Override
  public ValidationResult validateEvent(IncomingEvent event, ValidationType validationType) {
    switch (validationType) {
    case NEW:
    case REVALIDATE:
    case EDIT:
      return movementEventValidation.validate(event, validationType);
    case CREATION:
    case TERMINATION:
      return equipmentEventValidation.validate(event, validationType);
    default:
      return null;
    }
  }
}
