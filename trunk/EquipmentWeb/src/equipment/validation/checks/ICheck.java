package equipment.validation.checks;

import equipment.validation.ValidationEnvironment;

public interface ICheck {
  String getName();
  void validate(ValidationEnvironment validationEnvironment);
}
