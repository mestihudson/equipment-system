package equipment.validation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("equipmentEventValidation")
@Scope("prototype")
public class EquipmentEventValidation extends EventValidationTemplate{
  private ValidationResult validationResult;
  @Override
  protected void applyRules() {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void processResults() {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected ValidationResult getValidationResult() {
    return validationResult;
  }

  public void setValidationResult(ValidationResult validationResult) {
    this.validationResult = validationResult;
  }
}
