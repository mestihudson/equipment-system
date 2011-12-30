package equipment.web.jsf.mbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.bo.ContainerNumberResolver;
import equipment.domain.enums.EquipmentType;
import equipment.domain.enums.SubEventType;
import equipment.domain.enums.ValidationType;
import equipment.exceptions.ContainerConvertException;
import equipment.service.ContainerIsoTypeService;
import equipment.service.ContainerService;
import equipment.service.EventValidationService;
import equipment.utils.StringUtil;
import equipment.validation.IncomingEquipmentEvent;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationResult;

@Component("equipmentCTBean")
@Scope("view")
public class EquipmentCreationTerminationBean extends AbstractManagedBean {
  private static final long serialVersionUID = 964800661749286255L;

  private String containerNumber;
  private char containerCheckDigit;
  private Set<String> containerNumbers = new TreeSet<String>();
  private SubEventType selectedSubEventType;
  private Date activityDateTime;
  private String facilityCode;
  private String groupCode;
  private String isoCode;
  private String referenceNumber;
  private String materialType;
  private String selectedContainerNumber;

  @Resource(name = "containerService")
  private ContainerService containerService;

  @Resource(name = "containerIsoTypeService")
  private ContainerIsoTypeService containerIsoTypeService;

  @Resource(name = "eventValidationService")
  private EventValidationService eventValidationService;

  public void addContainer() {
    try {
      containerNumbers.add(ContainerNumberResolver.formContainerNumber(containerNumber, containerCheckDigit));
    } catch (ContainerConvertException cce) {
      addErrorMessage(cce.getDetailMessage());
    }
  }

  public void removeContainer() {
    if (selectedContainerNumber != null) {
      containerNumbers.remove(selectedContainerNumber);
    }
  }

  public EnumSet<SubEventType> getSubEventTypesForCreation() {
    return EnumSet.of(SubEventType.ON_HIRE, SubEventType.PURCHASE, SubEventType.SOC);
  }

  public EnumSet<SubEventType> getSubEventTypesForTermination() {
    return EnumSet.of(SubEventType.OFF_HIRE, SubEventType.SOLD, SubEventType.END_SOC);
  }

  public char calculateCheckDigit(String containerNumber) {
    return containerService.calculateCheckDigit(containerNumber);
  }

  public void saveCreation() {
    if (containerNumbers.size() == 0) {
      addErrorMessage("Container Number is mandatory");
    } else {
      for (IncomingEvent event : getIncomingEvents()) {
        try {
          ValidationResult result = eventValidationService.validateEvent(event, ValidationType.CREATION);
          if (result.hasRejection()) {
            addWarnMessage(event.getEquipmentNumber() + " has rejected.  Please process it in rejections.");
          } else {
            addInfoMessage(event.getEquipmentNumber() + " was successfully created.");
          }
        } catch (Throwable e) {
          addErrorMessage(event.getEquipmentNumber() + " failed to create.");
        }
      }
    }
  }

  public void saveTermination() {
    if (containerNumbers.size() == 0) {
      addErrorMessage("Container Number is mandatory");
    } else {
      for (IncomingEvent event : getIncomingEvents()) {
        eventValidationService.validateEvent(event, ValidationType.TERMINATION);
      }
    }
  }

  public void containerSelectListener(ValueChangeEvent event) {
    selectedContainerNumber = (String) event.getNewValue();
  }

  private Collection<IncomingEvent> getIncomingEvents() {
    Collection<IncomingEvent> incomingEvents = new ArrayList<IncomingEvent>();
    for (String containerNumber : containerNumbers) {
      if (containerNumber == null) {
        continue;
      }
      try {
        IncomingEquipmentEvent event = new IncomingEquipmentEvent();
        event.setEquipmentNumber(ContainerNumberResolver.resolveContainerNumber(containerNumber));
        event.setCheckDigit(ContainerNumberResolver.resolveCheckDigit(containerNumber));
        event.setEquipmentType(EquipmentType.CONTAINER);
        event.setEventDateTime(activityDateTime);
        event.setEventType(this.selectedSubEventType);
        event.setEquipmentTypeCode(isoCode);
        event.setEquipmentTypeGroupCode(groupCode);
        event.setFacilityCode(facilityCode);
        event.setDocumentNumber(referenceNumber);
        incomingEvents.add(event);
      } catch (ContainerConvertException cce) {

      }
    }
    return incomingEvents;
  }

  public Collection<SelectItem> getGroupCodes() {
    Collection<SelectItem> selectItems = new ArrayList<SelectItem>();
    if (StringUtil.isNullOrEmptyWithTrim(isoCode)) {
      selectItems.add(new SelectItem("-", "-", null, false, false, true));
      for (String groupCode : containerIsoTypeService.getAllGroupCodes()) {
        selectItems.add(new SelectItem(groupCode));
      }
    } else {
      selectItems.add(new SelectItem(containerIsoTypeService.getGroupByIso(isoCode)));
    }
    return selectItems;
  }

  public Collection<String> getIsoCodes() {
    if (StringUtil.isNullOrEmptyWithTrim(groupCode)) {
      return containerIsoTypeService.getAllIsoCodes();
    } else {
      return containerIsoTypeService.getIsoByGroup(groupCode);
    }
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public char getContainerCheckDigit() {
    return containerCheckDigit;
  }

  public void setContainerCheckDigit(char containerCheckDigit) {
    this.containerCheckDigit = containerCheckDigit;
  }

  public Set<String> getContainerNumbers() {
    return containerNumbers;
  }

  public void setContainerNumbers(Set<String> containerNumbers) {
    this.containerNumbers = containerNumbers;
  }

  public SubEventType getSelectedSubEventType() {
    return selectedSubEventType;
  }

  public void setSelectedSubEventType(SubEventType selectedSubEventType) {
    this.selectedSubEventType = selectedSubEventType;
  }

  public Date getActivityDateTime() {
    return activityDateTime;
  }

  public void setActivityDateTime(Date activityDateTime) {
    this.activityDateTime = activityDateTime;
  }

  public String getFacilityCode() {
    return facilityCode;
  }

  public void setFacilityCode(String facilityCode) {
    this.facilityCode = facilityCode;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getMaterialType() {
    return materialType;
  }

  public void setMaterialType(String materialType) {
    this.materialType = materialType;
  }

  public String getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  public String getSelectedContainerNumber() {
    return selectedContainerNumber;
  }

  public void setSelectedContainerNumber(String selectedContainerNumber) {
    this.selectedContainerNumber = selectedContainerNumber;
  }
}
