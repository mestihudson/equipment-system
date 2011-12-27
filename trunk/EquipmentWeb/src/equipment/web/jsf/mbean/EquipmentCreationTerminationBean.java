package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.enums.SubEventType;
import equipment.domain.enums.ValidationType;
import equipment.service.ContainerIsoTypeService;
import equipment.service.ContainerService;
import equipment.service.EventValidationService;
import equipment.utils.StringUtil;
import equipment.validation.IncomingEquipmentEvent;
import equipment.validation.IncomingEvent;

@Component("equipmentCTBean")
@Scope("view")
public class EquipmentCreationTerminationBean extends AbstractManagedBean {
  private static final long serialVersionUID = 964800661749286255L;

  private String containerNumber;
  private char containerCheckDigit;
  private Set<String> checkedContainerNumbers = new TreeSet<String>();
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
    if (StringUtil.isNullOrEmptyWithTrim(containerNumber)) {
      return;
    }
    if (containerCheckDigit == 0) {
      return;
    }
    checkedContainerNumbers.add(this.containerNumber.toUpperCase() + "-" + this.containerCheckDigit);
  }

  public void removeContainer() {
    if (selectedContainerNumber != null) {
      checkedContainerNumbers.remove(selectedContainerNumber);
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

  public void save() {
    if (checkedContainerNumbers.size() == 0) {
      addErrorMessage("Container Number is mandatory");
    } else {
      eventValidationService.validateEvent(getIncomingEvent(), ValidationType.CREATION);
    }
  }

  public void containerSelectListener(ValueChangeEvent event) {
    selectedContainerNumber = (String) event.getNewValue();
  }

  private IncomingEvent getIncomingEvent() {
    return new IncomingEquipmentEvent();
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

  public Set<String> getCheckedContainerNumbers() {
    return checkedContainerNumbers;
  }

  public void setCheckedContainerNumbers(Set<String> checkedContainerNumbers) {
    this.checkedContainerNumbers = checkedContainerNumbers;
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
