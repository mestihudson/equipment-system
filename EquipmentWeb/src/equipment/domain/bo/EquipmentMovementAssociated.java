package equipment.domain.bo;

import java.io.Serializable;
import java.util.Date;

import equipment.domain.entity.EquipmentEvent;
import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.ContraAction;

public class EquipmentMovementAssociated implements Serializable, Comparable<EquipmentMovementAssociated> {
  private static final long serialVersionUID = -3197544701605533870L;

  private EquipmentEvent equipmentEvent;
  private MovementEvent movementEvent;
  private int eventCategory;

  public EquipmentMovementAssociated(MovementEvent movementEvent) {
    this.movementEvent = movementEvent;
    this.eventCategory = 1;
  }

  public EquipmentMovementAssociated(EquipmentEvent equipmentEvent) {
    this.equipmentEvent = equipmentEvent;
    this.eventCategory = 0;
  }

  public String getFacilityCode() {
    if (eventCategory == 0) {
      return equipmentEvent.getLocation();
    } else {
      return movementEvent.getFacilityCode();
    }
  }

  public String getContainerNumber() {
    if (eventCategory == 0) {
      return equipmentEvent.getEquipmentNumber();
    } else {
      return movementEvent.getContainerNumber();
    }
  }

  public Date getEventDateTime() {
    if (eventCategory == 0) {
      return equipmentEvent.getEventDateTime();
    } else {
      return movementEvent.getEventDateTime();
    }
  }

  public ContraAction getContraAction() {
    if (eventCategory == 0) {
      return ContraAction.NEW;
    } else {
      return movementEvent.getContraAction();
    }
  }

  public String getUpdateUser() {
    if (eventCategory == 0) {
      return equipmentEvent.getUpdateUser();
    } else {
      return movementEvent.getUpdateUser();
    }
  }

  public Date getRecordUpdateDateTime() {
    if (eventCategory == 0) {
      return equipmentEvent.getRecordUpdateDateTime();
    } else {
      return movementEvent.getRecordUpdateDateTime();
    }
  }
  
  public String getEventType() {
    if (eventCategory == 0) {
      return equipmentEvent.getEventType().getDescription();
    } else {
      return movementEvent.getEventType().getDescription();
    }
  }

  @Override
  public int compareTo(EquipmentMovementAssociated o) {
    return 0 - this.getEventDateTime().compareTo(o.getEventDateTime());
  }
}
