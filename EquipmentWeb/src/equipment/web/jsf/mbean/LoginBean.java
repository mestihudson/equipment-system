package equipment.web.jsf.mbean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

  public void login() {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    ServletContext servletContext = (ServletContext) externalContext.getContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse respone = (HttpServletResponse) externalContext.getResponse();
    RequestDispatcher rd = servletContext.getRequestDispatcher("j_spring_security_check");
    try {
      rd.forward(request, respone);
    } catch (ServletException e) {
    } catch (IOException e) {
    } finally {
      FacesContext.getCurrentInstance().responseComplete();
    }
  }

}
