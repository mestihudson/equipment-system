package equipment.web.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

abstract class AbstractInputValidator implements Validator {

  @Override
  public abstract void validate(FacesContext facesContext, UIComponent uiComponent, Object newValue) throws ValidatorException;

  FacesMessage getErrorMessage(String summary, String detail) {
    return new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
  }
}
