package equipment.service;

import equipment.domain.enums.ValidationType;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationResult;

public interface EventValidationService {
  ValidationResult validateEvent(IncomingEvent event, ValidationType validationType);
}
