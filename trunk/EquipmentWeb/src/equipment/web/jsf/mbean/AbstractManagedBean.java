package equipment.web.jsf.mbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public abstract class AbstractManagedBean implements Serializable {
  private static final long serialVersionUID = -7229329429527458258L;

  protected void addFatalMessage(String message) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
  }
  protected void addErrorMessage(String message) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
  }
  protected void addWarnMessage(String message) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
  }
  protected void addInfoMessage(String message) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
  }
  
  protected void addCallBackParam(String name, Object value) {
    RequestContext.getCurrentInstance().addCallbackParam(name, value);
  }
}
