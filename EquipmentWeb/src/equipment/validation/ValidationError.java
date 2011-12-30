package equipment.validation;

import equipment.domain.enums.ErrorMessage;

public class ValidationError {
  private String ruleName;
  private ErrorMessage errorMessage;
  
  public ValidationError(String ruleName, ErrorMessage errorMessage) {
    this.ruleName = ruleName;
    this.errorMessage = errorMessage;
  }
  public String getRuleName() {
    return ruleName;
  }
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }
  public ErrorMessage getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(ErrorMessage errorMessage) {
    this.errorMessage = errorMessage;
  }
}
