package equipment.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.bo.ContainerNumberResolver;
import equipment.domain.entity.Container;
import equipment.domain.entity.EquipmentEvent;
import equipment.domain.entity.EquipmentLatestInfo;
import equipment.domain.entity.MovementEvent;
import equipment.domain.entity.Rejection;
import equipment.domain.entity.RejectionDetail;
import equipment.domain.enums.ContraAction;
import equipment.domain.enums.ErrorMessage;
import equipment.domain.enums.ValidationType;
import equipment.exceptions.ContainerConvertException;
import equipment.service.ContainerService;
import equipment.service.EquipmentEventService;
import equipment.service.EquipmentLatestInfoService;
import equipment.service.MovementEventService;
import equipment.utils.TimestampUtil;
import equipment.validation.checks.AbstractValidationCheck;

@Component("validationEnvironment")
@Scope("prototype")
public class ValidationEnvironment {
  private IncomingEvent incomingEvent;
  private ValidationResult validationResult;
  private ValidationType validationType;

  /* Lazy properties Start */
  private String eventTimestamp;
  private EquipmentLatestInfo equpimentLatestInfo;
  private Container containerInfo;
  /* Lazy properties End */

  @Resource(name = "equipmentLatestInfoService")
  private EquipmentLatestInfoService equipmentLatestInfoService;

  @Resource(name = "movementEventService")
  private MovementEventService movementEventService;

  @Resource(name = "equipmentEventService")
  private EquipmentEventService equipmentEventService;

  @Resource(name = "containerService")
  private ContainerService containerService;
  
  public void initialize() {
    eventTimestamp = null;
    equpimentLatestInfo = null;
    containerInfo = null;
    validationResult = new ValidationResult();
  }

  public void raiseRejection(AbstractValidationCheck check, ErrorMessage errorMessage) {
    validationResult.addValidationError(new ValidationError(check.getName(), errorMessage));
  }

  public Date getEventDateTime() {
    return incomingEvent.getEventDateTime();
  }

  public IncomingEvent getIncomingEvent() {
    return incomingEvent;
  }

  public void setIncomingEvent(IncomingEvent incomingEvent) {
    this.incomingEvent = incomingEvent;
  }

  public void setValidationResult(ValidationResult validationResult) {
    this.validationResult = validationResult;
  }

  public ValidationType getValidationType() {
    return validationType;
  }

  public void setValidationType(ValidationType validationType) {
    this.validationType = validationType;
  }

  public ValidationResult getValidationResult() {
    return validationResult;
  }

  public String getEventTimestamp() {
    if (eventTimestamp == null) {
      eventTimestamp = UUID.randomUUID().toString().replaceAll("-", "");
    }
    return eventTimestamp;
  }

  public Rejection createRejection() {
    Rejection rejection = new Rejection();
    rejection.setEventTimestamp(getEventTimestamp());
    // TODO set values into rejection
    Collection<RejectionDetail> rejectionDetails = new ArrayList<RejectionDetail>();
    for (ValidationError error : validationResult.getValidationErrors()) {
      RejectionDetail detail = new RejectionDetail();
      detail.setEventTimestamp(getEventTimestamp());
      detail.setRejectionCode(error.getErrorMessage().getCode());
      detail.setRuleName(error.getRuleName());
      rejectionDetails.add(detail);
    }
    return rejection;
  }

  public EquipmentLatestInfo getEquipmentLatestInfo() {
    if (equpimentLatestInfo == null) {
      equpimentLatestInfo = equipmentLatestInfoService.findByEquipmentNumber(incomingEvent.getEquipmentNumber());
    }
    return equpimentLatestInfo;
  }

  public MovementEvent createMovementEventLog() {
    if (validationType == ValidationType.NEW) {
      IncomingMovementEvent incomingMovementEvent = (IncomingMovementEvent) incomingEvent;
      MovementEvent movementEvent = new MovementEvent();
      movementEvent.setEventTimestamp(getEventTimestamp());
      movementEvent.setEventCreationDateTime(TimestampUtil.now());
      movementEvent.setRecordUpdateDateTime(TimestampUtil.now());
      BeanUtils.copyProperties(incomingMovementEvent, movementEvent, new String[] { "equipmentNumber" });
      movementEvent.setContainerNumber(incomingMovementEvent.getEquipmentNumber());
      return movementEvent;
    } else {
      return null;
    }
  }

  public EquipmentEvent createEquipmentEventLog() {
    if (validationType == ValidationType.CREATION || validationType == ValidationType.TERMINATION) {
      IncomingEquipmentEvent incomingEquipmentEvent = (IncomingEquipmentEvent) incomingEvent;
      EquipmentEvent equipmentEvent = new EquipmentEvent();
      equipmentEvent.setEventTimestamp(getEventTimestamp());
      BeanUtils.copyProperties(incomingEquipmentEvent, equipmentEvent, new String[] { "facilityCode" });
      equipmentEvent.setLocation(incomingEquipmentEvent.getFacilityCode());
      equipmentEvent.setRecordUpdateDateTime(TimestampUtil.now());
      // equipmentEvent.setEquipmentNumber(incomingEquipmentEvent.getEquipmentNumber());
      // equipmentEvent.setEquipmentType(incomingEquipmentEvent.getEquipmentType());
      // equipmentEvent.setEquipmentTypeCode(incomingEquipmentEvent.getEquipmentTypeCode());
      // equipmentEvent.setEquipmentTypeGroupCode(incomingEquipmentEvent.getEquipmentTypeGroupCode());
      // equipmentEvent.setEventDateTime(incomingEquipmentEvent.getEventDateTime());
      // equipmentEvent.setEventType(incomingEquipmentEvent.getEventType());
      // equipmentEvent.setLocation(incomingEquipmentEvent.getFacilityCode());
      // equipmentEvent.setMaterial(incomingEquipmentEvent.getMaterial());
      // equipmentEvent.setUpdateUser(incomingEquipmentEvent.getUpdateUser());
      return equipmentEvent;
    } else {
      return null;
    }
  }

  public boolean isCurrent() {
    return getEquipmentLatestInfo() == null
        || getEquipmentLatestInfo().getEventDateTime().compareTo(incomingEvent.getEventDateTime()) <= 0;
  }

  public Container getContainerInfo() {
    if (containerInfo == null) {
      containerInfo = containerService.findByNumber(incomingEvent.getEquipmentNumber());
    }
    if (containerInfo == null) {
      if (validationType == ValidationType.CREATION) {
        containerInfo = new Container();
        containerInfo.setEquipmentNumber(incomingEvent.getEquipmentNumber());
        containerInfo.setActive(true);
        containerInfo.setCheckDigit(((IncomingEquipmentEvent) incomingEvent).getCheckDigit());
        containerInfo.setCreateDateTime(TimestampUtil.now());
        containerInfo.setGroupCode(((IncomingEquipmentEvent) incomingEvent).getEquipmentTypeGroupCode());
        containerInfo.setIsoCode(((IncomingEquipmentEvent) incomingEvent).getEquipmentTypeCode());
        containerInfo.setUpdateDateTime(TimestampUtil.now());
      }
    } else {
      containerInfo.setActive(validationType == ValidationType.CREATION);
      containerInfo.setUpdateDateTime(TimestampUtil.now());
    }
    return containerInfo;
  }

  public void update(EquipmentLatestInfo latestInfo) {
    latestInfo.setEquipmentNumber(incomingEvent.getEquipmentNumber());
    latestInfo.setEventTimestamp(getEventTimestamp());
    latestInfo.setCurrentLocation(incomingEvent.getFacilityCode());
    latestInfo.setEventDateTime(incomingEvent.getEventDateTime());
    latestInfo.setUpdateUser(incomingEvent.getUpdateUser());
    latestInfo.setRecordUpdateDateTime(TimestampUtil.now());
    if (validationType == ValidationType.CREATION || validationType == ValidationType.TERMINATION) {
      latestInfo.setEquipmentType(((IncomingEquipmentEvent) incomingEvent).getEquipmentType());
      latestInfo.setEventType(((IncomingEquipmentEvent) incomingEvent).getEventType().getCode());
      latestInfo.setDocumentReference(((IncomingEquipmentEvent) incomingEvent).getDocumentNumber());
      latestInfo.setIsoCode(((IncomingEquipmentEvent) incomingEvent).getEquipmentTypeCode());
      latestInfo.setGroupCode(((IncomingEquipmentEvent) incomingEvent).getEquipmentTypeGroupCode());
      latestInfo.setContraAction(ContraAction.NEW);
      latestInfo.setActive(validationType == ValidationType.CREATION);
    } else if (validationType == ValidationType.NEW || validationType == ValidationType.REVALIDATE
        || validationType == ValidationType.EDIT) {
      // TODO
    }
  }

}