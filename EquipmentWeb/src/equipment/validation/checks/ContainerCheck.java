package equipment.validation.checks;

import equipment.domain.entity.Container;
import equipment.domain.enums.ErrorMessage;
import equipment.domain.enums.ValidationType;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationEnvironment;

public class ContainerCheck extends AbstractValidationCheck {
  public final static String NAME = "Container Check";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public boolean applyTo(IncomingEvent event, ValidationType validationType) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    Container container = validationEnvironment.getContainerInfo();
    if(container == null) {
      validationEnvironment.raiseRejection(this, ErrorMessage.CONTAINER_NOT_EXISTS);
    } else if(container.isActive()) {
      validationEnvironment.raiseRejection(this, ErrorMessage.CONTAINER_INACTIVE);
    }
  }

}
