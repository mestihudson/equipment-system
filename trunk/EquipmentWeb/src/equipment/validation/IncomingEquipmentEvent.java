package equipment.validation;

import equipment.domain.enums.EquipmentType;
import equipment.domain.enums.SubEventType;

public class IncomingEquipmentEvent extends IncomingEvent {
  private static final long serialVersionUID = 6835604447534876707L;
  private EquipmentType equipmentType;
  private SubEventType eventType;
  private String equipmentTypeGroupCode;
  private String equipmentTypeCode;
  private String material;
  private String documentNumber;
  private char checkDigit;
  
  public EquipmentType getEquipmentType() {
    return equipmentType;
  }
  public void setEquipmentType(EquipmentType equipmentType) {
    this.equipmentType = equipmentType;
  }
  public SubEventType getEventType() {
    return eventType;
  }
  public void setEventType(SubEventType eventType) {
    this.eventType = eventType;
  }
  public String getEquipmentTypeGroupCode() {
    return equipmentTypeGroupCode;
  }
  public void setEquipmentTypeGroupCode(String equipmentTypeGroupCode) {
    this.equipmentTypeGroupCode = equipmentTypeGroupCode;
  }
  public String getEquipmentTypeCode() {
    return equipmentTypeCode;
  }
  public void setEquipmentTypeCode(String equipmentTypeCode) {
    this.equipmentTypeCode = equipmentTypeCode;
  }
  public String getMaterial() {
    return material;
  }
  public void setMaterial(String material) {
    this.material = material;
  }
  public String getDocumentNumber() {
    return documentNumber;
  }
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
  public char getCheckDigit() {
    return checkDigit;
  }
  public void setCheckDigit(char checkDigit) {
    this.checkDigit = checkDigit;
  }
}