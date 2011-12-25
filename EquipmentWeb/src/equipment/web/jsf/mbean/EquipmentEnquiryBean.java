package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("equipmentEnquiryBean")
@Scope("request")
public class EquipmentEnquiryBean implements Serializable {

  private static final long serialVersionUID = 2268013658546622642L;

  private String containerNumber;

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public void search() {

  }

  public Collection<String> getTablelist() {
    List<String> s = new ArrayList<String>();
    s.add("S");
    return s;
  }
}
