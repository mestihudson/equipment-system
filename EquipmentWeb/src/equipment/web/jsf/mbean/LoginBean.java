package equipment.web.jsf.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class LoginBean {

  private String username;

  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String login() {
    if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
      return "success";
    } else {
      FacesContext.getCurrentInstance().addMessage(null,
          new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials"));
      return "failure";
    }
  }
}
