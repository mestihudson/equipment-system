package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sizeTypeBean")
@Scope("request")
public class SizeTypeBean implements Serializable{
  private static final long serialVersionUID = 2458463346642161595L;
  private HashMap<String, String> sizeTypeGroup;

  public List<String> getSizeTypeGroups() {
    return null;
  }
  
  public List<String> getIsoCodes() {
    return null;
  }
}
