package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.EventType;
import equipment.service.EventValidationService;
import equipment.service.MovementEventService;

@Component("movementEventEditingBean")
@Scope("view")
public class MovementEventEditingBean implements Serializable {
  private static final long serialVersionUID = -1522497061055049165L;
  @Resource(name = "movementEventService")
  private MovementEventService movementEventService;
  @Resource(name = "eventValidationService")
  private EventValidationService eventValidationService;
  
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
    // Map<String, Object> propertyNameValues = new HashMap<String, Object>();
    // if(StringUtil.isNotNullAndNotEmptyWithTrim(containerNumber)) {
    // propertyNameValues.put("containerNumber", containerNumber);
    // }
    // if(eventType != null) {
    // propertyNameValues.put("eventType", eventType);
    // }
    // movementEvents = movementEventDao.findBy(propertyNameValues);
    // mediumEventsModel = new MovementEventDataModel(movementEvents);
    movementEvents=new ArrayList(movementEventService.findByContainerNumber(containerNumber));
    mediumEventsModel = new MovementEventDataModel(movementEvents);
  }
  public void delete(){
	  if(selectedEvents.length==0){
		  FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,"请选择必要操作", "您至少需要选择1条要删除的事件消息");
          FacesContext.getCurrentInstance().addMessage("请选择必要操作", fm);
	  }else{
		  int count =movementEventService.removeEvents(selectedEvents);
		  if(count>0){
		  FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,"", "成功删除"+count+"条消息");
		  FacesContext.getCurrentInstance().addMessage("", fm);
		  search();
		  }
	  }
  }
}
