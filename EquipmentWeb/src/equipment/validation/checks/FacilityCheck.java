package equipment.validation.checks;

import equipment.domain.entity.SupplyHierarchy;
import equipment.domain.enums.ErrorMessage;
import equipment.domain.enums.ValidationType;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationEnvironment;

public class FacilityCheck extends AbstractValidationCheck {

  @Override
  public String getName() {
    return "Facility Check";
  }

  @Override
  public boolean applyTo(IncomingEvent event, ValidationType validationType) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    SupplyHierarchy supplyHierarchy = validationEnvironment.getSupplyHierarchy();
    if(supplyHierarchy == null) {
      validationEnvironment.raiseRejection(this, ErrorMessage.FACILITY_NOT_EXISTS);
    }
  }

}
