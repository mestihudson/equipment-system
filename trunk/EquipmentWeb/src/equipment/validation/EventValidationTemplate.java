package equipment.validation;

import equipment.domain.enums.ValidationType;

public abstract class EventValidationTemplate {
  public ValidationResult validate(IncomingEvent event, ValidationType validationType) {
    applyRules();
    processResults();
    return getValidationResult();
  }
  protected abstract void applyRules();
  protected abstract void processResults();
  protected abstract ValidationResult getValidationResult();
}
