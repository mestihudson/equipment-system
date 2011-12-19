package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.MovementEventDao;
import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.EventType;
import equipment.utils.StringUtil;

@Component("movementEnquiryBean")
@Scope("request")
public class MovementEnquiryBean implements Serializable {
  private static final long serialVersionUID = -1522497061055049165L;
  @Resource(name = "movementEventDao")
  private MovementEventDao movementEventDao;

  private String containerNumber;
  private EventType eventType;
  private MovementEventDataModel mediumEventsModel;

  private List<MovementEvent> movementEvents;
  private MovementEvent[] selectedEvents;

  public List<MovementEvent> getMovementEvents() {
    return movementEvents;
  }

  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK, EventType.STATUS_CHANGE);
  }
  
  public MovementEvent[] getSelectedEvents() {
    return selectedEvents;
  }

  public void setSelectedEvents(MovementEvent[] selectedEvents) {
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

  public MovementEventDataModel getMediumEventsModel() {
    return mediumEventsModel;
  }

  public void setMediumEventsModel(MovementEventDataModel mediumEventsModel) {
    this.mediumEventsModel = mediumEventsModel;
  }

  public void search() {
    Map<String, Object> propertyNameValues = new HashMap<String, Object>();
    if(StringUtil.isNotNullAndNotEmptyWithTrim(containerNumber)) {
      propertyNameValues.put("containerNumber", containerNumber);
    }
    if(eventType != null) {
      propertyNameValues.put("eventType", eventType);
    }
    movementEvents = movementEventDao.findBy(propertyNameValues);
    mediumEventsModel = new MovementEventDataModel(movementEvents);
  }
}
