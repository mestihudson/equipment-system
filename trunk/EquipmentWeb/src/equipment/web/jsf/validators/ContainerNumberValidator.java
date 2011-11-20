package equipment.web.jsf.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("containerNumberValidator")
public class ContainerNumberValidator extends AbstractInputValidator {

  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Object newValue) throws ValidatorException {
    String containerNumber = ((String) newValue).trim();
    if (containerNumber.length() > 10) {
      throw new ValidatorException(getErrorMessage(null, "Container Number too long"));
    }
  }

}
