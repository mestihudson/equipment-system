package equipment.validation.checks;

import equipment.validation.IncomingEvent;
import equipment.validation.ValidationEnvironment;

public abstract class AbstractValidationCheck {

  public abstract String getName();
  
  public abstract boolean applyTo(IncomingEvent event);
  
  public abstract void validate(ValidationEnvironment validationEnvironment);
}
