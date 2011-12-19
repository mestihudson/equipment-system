package equipment.validation;

import equipment.domain.enums.ValidationType;

public interface IEventValidation {
  public ValidationResult validate(IncomingEvent event, ValidationType validationType);
}
