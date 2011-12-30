package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.entity.EquipmentLatestInfo;
import equipment.service.EquipmentLatestInfoService;

@Component("equipmentEnquiryBean")
@Scope("request")
public class EquipmentEnquiryBean implements Serializable {

  private static final long serialVersionUID = 2268013658546622642L;

  @Resource(name = "equipmentLatestInfoService")
  private EquipmentLatestInfoService equipmentLatestInfoService;

  private String containerNumber;

  private EquipmentLatestInfo equiplastinfo;

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public void search() {
    equiplastinfo = equipmentLatestInfoService.findByEquipmentNumber(containerNumber);
  }

  public Collection<String> getTablelist() {
    List<String> s = new ArrayList<String>();
    s.add("S");
    return s;
  }

  public EquipmentLatestInfo getEquiplastinfo() {
    return equiplastinfo;
  }

  public void setEquiplastinfo(EquipmentLatestInfo equiplastinfo) {
    this.equiplastinfo = equiplastinfo;
  }
}
