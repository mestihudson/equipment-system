package equipment.validation.checks;

import equipment.validation.IncomingEvent;
import equipment.validation.ValidationEnvironment;

public class ContainerCheck extends AbstractValidationCheck {
  public final static String NAME = "Container Check";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public boolean applyTo(IncomingEvent event) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    

  }

}
