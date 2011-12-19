package equipment.validation;

import java.io.Serializable;
import java.util.Date;

import equipment.domain.enums.EventType;

public abstract class IncomingEvent implements Serializable{
  private static final long serialVersionUID = -476649668008487830L;
  
  private String equipmentNumber;
  private EventType eventType;
  private String facilityCode;
  private Date eventDateTime;
  public String getEquipmentNumber() {
    return equipmentNumber;
  }
  public void setEquipmentNumber(String equipmentNumber) {
    this.equipmentNumber = equipmentNumber;
  }
  public EventType getEventType() {
    return eventType;
  }
  public void setEventType(EventType eventType) {
    this.eventType = eventType;
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
  
}
