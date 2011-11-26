package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.EquipmentEventDao;
import equipment.domain.EquipmentEvent;
import equipment.domain.enums.EventType;
import equipment.utils.StringUtil;

@Component("movementEnquiryBean")
@Scope("request")
public class MovementEnquiryBean implements Serializable{
	private static final long serialVersionUID = -1522497061055049165L;
  @Resource(name="equipmentEventDao")
  private EquipmentEventDao equipmentEventDao;
  
	private String containerNumber;
	private EventType eventType;
	private EquipmentEventDataModel mediumEventsModel;
	
	private List<EquipmentEvent> equipmentEvents;
  private EquipmentEvent[] selectedEvents;

	public List<EquipmentEvent> getEquipmentEvents() {
		return equipmentEvents;
	}

  public EquipmentEvent[] getSelectedEvents() {
    return selectedEvents;
  }

  public void setSelectedEvents(EquipmentEvent[] selectedEvents) {
    this.selectedEvents = selectedEvents;
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }
	
  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public EquipmentEventDataModel getMediumEventsModel() {
    return mediumEventsModel;
  }

  public void setMediumEventsModel(EquipmentEventDataModel mediumEventsModel) {
    this.mediumEventsModel = mediumEventsModel;
  }

  public void search() {
    if(StringUtil.isNullOrEmptyWithTrim(containerNumber)) {
      equipmentEvents = equipmentEventDao.findAll();
    } else {
      equipmentEvents = equipmentEventDao.findByContainerNumber(getContainerNumber());
    }
  }
}
