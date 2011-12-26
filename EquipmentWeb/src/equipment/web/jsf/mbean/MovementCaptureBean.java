package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.EnumSet;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.enums.Direction;
import equipment.domain.enums.DocumentType;
import equipment.domain.enums.EquipmentCondition;
import equipment.domain.enums.EventType;
import equipment.domain.enums.LoadEmptyIndicator;
import equipment.domain.enums.ValidationType;
import equipment.domain.enums.WeightUnit;
import equipment.service.EventValidationService;
import equipment.validation.IncomingMovementEvent;

@Component("movementCaptureBean")
@Scope("request")
public class MovementCaptureBean implements Serializable {

  private static final long serialVersionUID = 1906335266687624174L;

  @Resource(name = "eventValidationService")
  private EventValidationService eventValidationService;

  private IncomingMovementEvent incomingEvent;
  
  public IncomingMovementEvent getIncomingEvent() {
    if (incomingEvent == null) {
      incomingEvent = new IncomingMovementEvent();
    }
    return incomingEvent;
  }

  public EnumSet<WeightUnit> getWeightUnits() {
    return EnumSet.allOf(WeightUnit.class);
  }

  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK, EventType.STATUS_CHANGE);
  }

  public EnumSet<LoadEmptyIndicator> getLoadEmptyIndicators() {
    return EnumSet.allOf(LoadEmptyIndicator.class);
  }

  public EnumSet<EquipmentCondition> getEquipmentConditions() {
    return EnumSet.allOf(EquipmentCondition.class);
  }

  public EnumSet<DocumentType> getDocumentTypes() {
    return EnumSet.of(DocumentType.BM, DocumentType.BN, DocumentType.EP);
  }

  public EnumSet<Direction> getDirections() {
    return EnumSet.allOf(Direction.class);
  }

  public void save() {
    buildIncomingEvent();
    eventValidationService.validateEvent(getIncomingEvent(), ValidationType.NEW);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Movement Capturing", "Save Successful"));
  }

  private void buildIncomingEvent() {
  }

}
