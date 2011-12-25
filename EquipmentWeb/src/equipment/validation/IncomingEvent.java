package equipment.validation;

import java.io.Serializable;
import java.util.Date;

import equipment.domain.enums.EventType;

public abstract class IncomingEvent implements Serializable{
  private static final long serialVersionUID = -476649668008487830L;
  
  private String equipmentNumber;
  private String facilityCode;
  private Date eventDateTime;
  private String updateUser;
  
  public String getEquipmentNumber() {
    return equipmentNumber;
  }
  public void setEquipmentNumber(String equipmentNumber) {
    this.equipmentNumber = equipmentNumber;
  }
  public String getFacilityCode() {
    return facilityCode;
  }
  public void setFacilityCode(String facilityCode) {
    this.facilityCode = facilityCode;
  }
  public Date getEventDateTime() {
    return eventDateTime;
  }
  public void setEventDateTime(Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }
  public String getUpdateUser() {
    return updateUser;
  }
  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }
  
}
