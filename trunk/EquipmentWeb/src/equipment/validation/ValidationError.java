package equipment.validation;

import equipment.domain.enums.ErrorMessage;

public class ValidationError {
  private ErrorMessage errorMessage;
  private String ruleName;
  public ErrorMessage getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(ErrorMessage errorMessage) {
    this.errorMessage = errorMessage;
  }
  public String getRuleName() {
    return ruleName;
  }
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }
}
