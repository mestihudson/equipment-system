package equipment.web.jsf.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

import equipment.utils.StringUtil;

@FacesValidator("containerNumberValidator")
public class ContainerNumberValidator extends AbstractInputValidator {

  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Object newValue) throws ValidatorException {
    String containerNumber = ((String) newValue).trim();
    if(StringUtil.isNullOrEmptyWithTrim(containerNumber)) {
      return;
    }
    if (containerNumber.indexOf("-") >= 0) {
      containerNumber = containerNumber.substring(0, containerNumber.indexOf("-"));
    }
    if (containerNumber.length() != 10) {
      throw new ValidatorException(getErrorMessage("Invalid container number", "The length of container number must be 10"));
    }
  }
}
