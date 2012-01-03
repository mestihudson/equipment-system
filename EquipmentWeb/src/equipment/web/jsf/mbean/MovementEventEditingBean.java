package equipment.web.jsf.mbean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.MovementEventDao;
import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.ContraAction;
import equipment.domain.enums.EventType;
import equipment.domain.enums.ValidationType;
import equipment.service.EventValidationService;
import equipment.service.MovementEventService;
import equipment.utils.StringUtil;
import equipment.validation.IncomingMovementEvent;
import equipment.validation.ValidationError;
import equipment.validation.ValidationResult;

@Component("movementEventEditingBean")
@Scope("view")
public class MovementEventEditingBean extends AbstractManagedBean {
  private static final long serialVersionUID = -1522497061055049165L;
  @Autowired
  private MovementEventService movementEventService;
  @Autowired
  private MovementEventDao movementEventDao;
  @Autowired
  private EventValidationService eventValidationService;

  private String containerNumber;
  private EventType eventType;
  private MovementEventDataModel mediumEventsModel;

  private List<MovementEvent> movementEvents;
  private MovementEvent[] selectedEvents;
  private MovementEvent movementInDialog = new MovementEvent();

  public List<MovementEvent> getMovementEvents() {
    return movementEvents;
  }

  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK);
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
    if (StringUtil.isNotNullAndNotEmptyWithTrim(containerNumber)) {
      propertyNameValues.put(MovementEventDao.CNTR_NUM, containerNumber);
    }
    if (eventType != null) {
      propertyNameValues.put(MovementEventDao.EVENT_TYPE, eventType);
    }
    List<MovementEvent> movementEvent = movementEventDao.findBy(propertyNameValues);
    mediumEventsModel = new MovementEventDataModel(movementEvent);
  }

  public void delete() {
    if (selectedEvents.length == 0) {
      FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "请选择必要操作", "您至少需要选择1条要删除的事件消息");
      FacesContext.getCurrentInstance().addMessage("请选择必要操作", fm);
    } else {
      int count = movementEventService.deleteEvents(selectedEvents);
      if (count > 0) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "成功删除" + count + "条消息");
        FacesContext.getCurrentInstance().addMessage("", fm);
        search();
      }
    }
    for (MovementEvent event : selectedEvents) {
      List<?> events = (List<?>) mediumEventsModel.getWrappedData();
      events.remove(event);
    }
  }

  public void save(ActionEvent actionEvent) {
    boolean saveSuccess = false;
    try {
      ValidationResult result = eventValidationService.validateEvent(createIncomingMovementEvent(movementInDialog),
          ValidationType.EDIT);
      if (result.hasRejection()) {
        addWarnMessage("Cannot Update because the rejection as below");
        for (ValidationError error : result.getValidationErrors()) {
          addWarnMessage(error.getErrorMessage().getDescription());
        }
        return;
      } else {
        movementInDialog.setContraAction(ContraAction.EDIT);
        movementEventDao.saveOrUpdate(movementInDialog);
      }
      MovementEvent movementEvent = mediumEventsModel.getRowData(movementInDialog.getEventTimestamp());
      BeanUtils.copyProperties(movementInDialog, movementEvent);
      saveSuccess = true;
      addInfoMessage("Event updated");
    } catch (Exception e) {
      addErrorMessage("Update failed");
    } finally {
      addCallBackParam("saveSuccess", saveSuccess);
    }
  }

  public IncomingMovementEvent createIncomingMovementEvent(MovementEvent movementEvent) {
    IncomingMovementEvent event = new IncomingMovementEvent();
    event.setEquipmentNumber(movementEvent.getContainerNumber());
    event.setFacilityCode(movementEvent.getFacilityCode());
    event.setEventType(movementEvent.getEventType());
    event.setEventDateTime(movementEvent.getEventDateTime());
    event.setServiceLoop(movementEvent.getServiceLoop());
    event.setVesselCode(movementEvent.getVesselCode());
    event.setVoyageNumber(movementEvent.getVoyageNumber());
    event.setDirectionBound(movementEvent.getDirectionBound());
    event.setLoadEmptyIndicator(movementEvent.getLoadEmptyIndicator());
    event.setSealType(movementEvent.getSealType());
    event.setSealNumber(movementEvent.getSealNumber());
    event.setLoadPort(movementEvent.getLoadPort());
    event.setDischargePort(movementEvent.getDischargePort());
    event.setDocumentReference(movementEvent.getDocumentReference());
    event.setDocumentType(movementEvent.getDocumentType());
    event.setGrossWeight(movementEvent.getGrossWeight());
    event.setGrossWeightUnit(movementEvent.getGrossWeightUnit());
    return event;
  }

  public MovementEvent getMovementInDialog() {
    return movementInDialog;
  }

  public void setMovementInDialog(MovementEvent movementInDialog) {
    this.movementInDialog = movementInDialog;
  }
}
