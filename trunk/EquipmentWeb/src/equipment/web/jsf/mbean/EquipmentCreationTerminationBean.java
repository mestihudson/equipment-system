package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.enums.EventType;
import equipment.domain.enums.SubEventType;
import equipment.domain.objects.CheckedContainerNumber;
import equipment.service.ContainerService;
import equipment.utils.StringUtil;

@Component("equipmentCTBean")
@Scope("view")
public class EquipmentCreationTerminationBean implements Serializable {
  private static final long serialVersionUID = 964800661749286255L;

  private String containerNumber;
  private char containerCheckDigit;
  private Set<CheckedContainerNumber> checkedContainerNumbers = new TreeSet<CheckedContainerNumber>();
  private SubEventType selectedSubEventType;
  private Date activityDateTime;
  private String facilityCode;
  
  @Resource(name = "containerService")
  private ContainerService containerService;

  public char calculateCheckDigit(String containerNumber) {
    return containerService.calculateCheckDigit(containerNumber);
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

  public Set<CheckedContainerNumber> getCheckedContainerNumbers() {
    return checkedContainerNumbers;
  }

  public void setCheckedContainerNumbers(Set<CheckedContainerNumber> checkedContainerNumbers) {
    this.checkedContainerNumbers = checkedContainerNumbers;
  }

  public void addContainer() {
    if (StringUtil.isNullOrEmptyWithTrim(containerNumber)) {
      return;
    }
    if (containerCheckDigit == 0) {
      return;
    }
    checkedContainerNumbers.add(new CheckedContainerNumber(this.containerNumber, this.containerCheckDigit));
  }

  public EnumSet<SubEventType> getSubEventTypes() {
    return EnumSet.of(SubEventType.ON_HIRE, SubEventType.PURCHASE, SubEventType.SOC);
  }
  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK, EventType.STATUS_CHANGE);
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
}
