package equipment.web.jsf.mbean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.bo.EquipmentMovementAssociated;
import equipment.domain.entity.EquipmentEvent;
import equipment.domain.entity.EquipmentLatestInfo;
import equipment.domain.entity.MovementEvent;
import equipment.service.EquipmentEventService;
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
  
  @Resource(name = "equipmentEventService")
  private EquipmentEventService equipmentEventService;

  private String containerNumber;

  private EquipmentLatestInfo equipmentLatestInfo = new EquipmentLatestInfo();

  private Map<Date, EquipmentMovementAssociated> eventLogs = new TreeMap<Date, EquipmentMovementAssociated>();

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public void search() {
    EquipmentLatestInfo equipmentLatestInfo = equipmentLatestInfoService.findByEquipmentNumber(containerNumber);
    if (equipmentLatestInfo == null) {
      addErrorMessage("Equipment not exists");
    } else {
      setEquipmentLatestInfo(equipmentLatestInfo);
      List<MovementEvent> movementEvents = movementEventService.findByContainerNumber(containerNumber);
      for(MovementEvent movementEvent : movementEvents) {
        eventLogs.put(movementEvent.getEventDateTime(), new EquipmentMovementAssociated(movementEvent));
      }
      List<EquipmentEvent> equipmentEvents = equipmentEventService.findByEquipmentNumber(containerNumber);
      for(EquipmentEvent equipmentEvent : equipmentEvents) {
        eventLogs.put(equipmentEvent.getEventDateTime(), new EquipmentMovementAssociated(equipmentEvent));
      }
    }
  }

  public Collection<EquipmentMovementAssociated> getTablelist() {
    return eventLogs.values();
  }

  public EquipmentLatestInfo getEquipmentLatestInfo() {
    return equipmentLatestInfo;
  }

  public void setEquipmentLatestInfo(EquipmentLatestInfo equipmentLatestInfo) {
    this.equipmentLatestInfo = equipmentLatestInfo;
  }

}
