package equipment.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import equipment.domain.enums.ContraAction;
import equipment.domain.enums.Direction;
import equipment.domain.enums.EquipmentType;

@Entity(name = "EQP_LATEST_INFO")
public class EquipmentLatestInfo implements Serializable {
  private static final long serialVersionUID = -8402222674061767273L;

  @Id
  @Column(name = "EQMT_NUM")
  private String equipmentNumber;

  @Column(name = "EQMT_TYPE", nullable = false, updatable = false)
  @Type(type = "equipment.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "equipment.domain.enums.EquipmentType"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getEquipmentTypeForCode") })
  private EquipmentType equipmentType;

  @Column(name = "EVENT_TYPE")
  private String eventType;

  @Column(name = "EVENT_TIMESTAMP")
  private String eventTimestamp;
  
  @Column(name = "EVENT_DT_LOC")
  private Date eventDateTime;
  
  @Column(name = "ISO_CDE")
  private String isoCode;

  @Column(name = "GROUP_CDE")
  private String groupCode;
  
  @Column(name = "ACTIVE")
  private boolean active;

  @Column(name = "CURR_LOCA")
  private String currentLocation;
  
  @Column(name = "NEXT_LOCA")
  private String nextLocation;
  
  @Column(name = "SVC_LOOP")
  private String serviceLoop;
  
  @Column(name = "VSL_CDE")
  private String vesselCode;
  
  @Column(name = "VOY_NUM")
  private String voyageNumber;
  
  @Enumerated(value = EnumType.STRING)
  @Column(name = "DIR_BOUND")
  private Direction directionBound;
  
  @Column(name = "CONTRA_ACTION")
  @Type(type = "equipment.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "equipment.domain.enums.ContraAction"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getContraActionForCode") })
  private ContraAction contraAction;
  
  @Column(name = "DOC_REF")
  private String documentReference;
  
  @Column(name = "DOC_TYPE")
  private String documentType;
  
  @Column(name = "LOAD_PORT")
  private String loadPort;

  @Column(name = "DSGH_PORT")
  private String dischargePort;

  @Column(name = "UPD_USER")
  private String updateUser;
  
  @Column(name = "REC_UPD_DT")
  private Date recordUpdateDateTime;

  public String getEquipmentNumber() {
    return equipmentNumber;
  }

  public void setEquipmentNumber(String equipmentNumber) {
    this.equipmentNumber = equipmentNumber;
  }

  public EquipmentType getEquipmentType() {
    return equipmentType;
  }

  public void setEquipmentType(EquipmentType equipmentType) {
    this.equipmentType = equipmentType;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public String getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public String getNextLocation() {
    return nextLocation;
  }

  public void setNextLocation(String nextLocation) {
    this.nextLocation = nextLocation;
  }

  public String getServiceLoop() {
    return serviceLoop;
  }

  public void setServiceLoop(String serviceLoop) {
    this.serviceLoop = serviceLoop;
  }

  public String getVesselCode() {
    return vesselCode;
  }

  public void setVesselCode(String vesselCode) {
    this.vesselCode = vesselCode;
  }

  public String getVoyageNumber() {
    return voyageNumber;
  }

  public void setVoyageNumber(String voyageNumber) {
    this.voyageNumber = voyageNumber;
  }

  public Direction getDirectionBound() {
    return directionBound;
  }

  public void setDirectionBound(Direction directionBound) {
    this.directionBound = directionBound;
  }

  public ContraAction getContraAction() {
    return contraAction;
  }

  public void setContraAction(ContraAction contraAction) {
    this.contraAction = contraAction;
  }

  public String getDocumentReference() {
    return documentReference;
  }

  public void setDocumentReference(String documentReference) {
    this.documentReference = documentReference;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getLoadPort() {
    return loadPort;
  }

  public void setLoadPort(String loadPort) {
    this.loadPort = loadPort;
  }

  public String getDischargePort() {
    return dischargePort;
  }

  public void setDischargePort(String dischargePort) {
    this.dischargePort = dischargePort;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getRecordUpdateDateTime() {
    return recordUpdateDateTime;
  }

  public void setRecordUpdateDateTime(Date recordUpdateDateTime) {
    this.recordUpdateDateTime = recordUpdateDateTime;
  }

  public Date getEventDateTime() {
    return eventDateTime;
  }

  public void setEventDateTime(Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }

  public String getEventTimestamp() {
    return eventTimestamp;
  }

  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}