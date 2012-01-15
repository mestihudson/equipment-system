package equipment.web.jsf.mbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public abstract class AbstractManagedBean implements Serializable {
  private static final long serialVersionUID = -7229329429527458258L;

  protected void addFatalMessage(String message) {
    addFatalMessage(message, null);
  }
  protected void addErrorMessage(String message) {
    addErrorMessage(message, null);
  }
  protected void addWarnMessage(String message) {
    addWarnMessage(message, null);
  }
  protected void addInfoMessage(String message) {
    addInfoMessage(message, null);
  }
  protected void addFatalMessage(String summary, String detail) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail));
  }
  protected void addErrorMessage(String summary, String detail) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
  }
  protected void addWarnMessage(String summary, String detail) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
  }
  protected void addInfoMessage(String summary, String detail) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
  }
  
  protected void addCallBackParam(String name, Object value) {
    RequestContext.getCurrentInstance().addCallbackParam(name, value);
  }
}
