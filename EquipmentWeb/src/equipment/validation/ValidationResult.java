package equipment.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
  private List<ValidationError> errors = new ArrayList<ValidationError>();
  
  public boolean hasRejection() {
    return errors.size() > 0;
  }
  
  public void addValidationError(ValidationError validationError) {
    errors.add(validationError);
  }
  
  public List<ValidationError> getValidationErrors() {
    return errors;
  }
}
