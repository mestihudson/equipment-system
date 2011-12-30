package equipment.validation.checks;

import equipment.domain.enums.ValidationType;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationEnvironment;

public abstract class AbstractValidationCheck {

  public abstract String getName();
  
  public abstract boolean applyTo(IncomingEvent event, ValidationType validationType);
  
  public abstract void validate(ValidationEnvironment validationEnvironment);
}
