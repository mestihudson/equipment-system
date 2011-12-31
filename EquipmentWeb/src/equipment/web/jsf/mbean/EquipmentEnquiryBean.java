package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.entity.EquipmentLatestInfo;
import equipment.domain.entity.MovementEvent;
import equipment.service.EquipmentLatestInfoService;
import equipment.service.MovementEventService;

@Component("equipmentEnquiryBean")
@Scope("request")
public class EquipmentEnquiryBean extends AbstractManagedBean {

  private static final long serialVersionUID = 2268013658546622642L;

  @Resource(name = "equipmentLatestInfoService")
  private EquipmentLatestInfoService equipmentLatestInfoService;
  
  @Resource(name = "movementEventService")
  private MovementEventService movementEventService;

  private String containerNumber;

  private EquipmentLatestInfo equipmentLatestInfo = new EquipmentLatestInfo();
  
  private Collection<MovementEvent> movementEvents;

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public void search() {
    EquipmentLatestInfo equipmentLatestInfo = equipmentLatestInfoService.findByEquipmentNumber(containerNumber);
    if(equipmentLatestInfo == null) {
      addErrorMessage("Equipment not exists");
    } else {
      setEquipmentLatestInfo(equipmentLatestInfo);
    }
  }

  public Collection<MovementEvent> getTablelist() {
    movementEvents=movementEventService.findByContainerNumber(containerNumber);
    return movementEvents;
  }

  public EquipmentLatestInfo getEquipmentLatestInfo() {
    return equipmentLatestInfo;
  }

  public void setEquipmentLatestInfo(EquipmentLatestInfo equipmentLatestInfo) {
    this.equipmentLatestInfo = equipmentLatestInfo;
  }

}
