package equipment.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import equipment.domain.enums.Direction;
import equipment.domain.enums.EquipmentCondition;
import equipment.domain.enums.EventType;
import equipment.domain.enums.LoadEmptyIndicator;
import equipment.domain.enums.WeightUnit;

@Entity
@Table(name = "EQP_EVENT_LOG")
public class EquipmentEvent {

	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	@Column(name = "EVENT_TIMESTAMP")
	private String eventTimestamp;

	@Column(name = "CNTR_NUM")
	private String containerNumber;

	@Column(name = "EVENT_CRE_DT")
	private Date eventCreationDateTime;

	@Column(name = "FCIL_CDE")
	private String facilityCode;

	@Column(name = "EVENT_TYPE")
	@Type(type = "equipment.utils.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "equipment.domain.enums.EventType"),
			@Parameter(name = "identifierMethod", value = "getCode"),
			@Parameter(name = "valueOfMethod", value = "getEventTypeForCode") })
	private EventType eventType;

	@Column(name = "EVENT_DT_LOC")
	private Date eventDateTimeLocal;

	@Column(name = "SEAL_NUM")
	private String sealNumber;

	@Column(name = "SEAL_TYPE")
	private String sealType;

	@Column(name = "CNTR_GRP_CDE")
	private String containerGroupCode;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "LOAD_EMPTY_IND")
	private LoadEmptyIndicator loadEmptyIndicator;

	@Column(name = "SVC_LOOP")
	private String serviceLoop;

	@Column(name = "VSL_CDE")
	private String vesselCode;

	@Column(name = "VOY_NUM")
	private String voyageNumber;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "DIR_BOUND")
	private Direction directionBound;

	@Column(name = "LOAD_PORT")
	private String loadPort;

	@Column(name = "DSGH_PORT")
	private String dischargePort;

	@Column(name = "NEXT_LOCA")
	private String nextLocation;

	@Column(name = "DOC_REF")
	private String documentReference;

	@Column(name = "DOC_TYPE")
	private String documentType;

	@Column(name = "GROSS_WT")
	private Double grossWeight;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "GROSS_WT_UNIT")
	private WeightUnit grossWeightUnit;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "CNTR_COND")
	private EquipmentCondition containerCondition;

	@Column(name = "HZ_IND")
	private Boolean hazardIndicator;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "CONTRA_ACTION")
	private String contraAction;

	@Column(name = "POS_AT_ROUTE")
	private String positionAtRoute;

	@Column(name = "NATURE")
	private String nature;

	@Column(name = "CNTR_CHK_DIGIT")
	private String containerCheckDigit;

	@Column(name = "UPD_USER")
	private String updateUser;

	@Column(name = "REC_UPD_DT")
	private Timestamp recordUpdateDateTime;

  public String getEventTimestamp() {
    return eventTimestamp;
  }

  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public Date getEventCreationDateTime() {
    return eventCreationDateTime;
  }

  public void setEventCreationDateTime(Date eventCreationDateTime) {
    this.eventCreationDateTime = eventCreationDateTime;
  }

  public String getFacilityCode() {
    return facilityCode;
  }

  public void setFacilityCode(String facilityCode) {
    this.facilityCode = facilityCode;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public Date getEventDateTimeLocal() {
    return eventDateTimeLocal;
  }

  public void setEventDateTimeLocal(Date eventDateTimeLocal) {
    this.eventDateTimeLocal = eventDateTimeLocal;
  }

  public String getSealNumber() {
    return sealNumber;
  }

  public void setSealNumber(String sealNumber) {
    this.sealNumber = sealNumber;
  }

  public String getSealType() {
    return sealType;
  }

  public void setSealType(String sealType) {
    this.sealType = sealType;
  }

  public String getContainerGroupCode() {
    return containerGroupCode;
  }

  public void setContainerGroupCode(String containerGroupCode) {
    this.containerGroupCode = containerGroupCode;
  }

  public LoadEmptyIndicator getLoadEmptyIndicator() {
    return loadEmptyIndicator;
  }

  public void setLoadEmptyIndicator(LoadEmptyIndicator loadEmptyIndicator) {
    this.loadEmptyIndicator = loadEmptyIndicator;
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

  public String getNextLocation() {
    return nextLocation;
  }

  public void setNextLocation(String nextLocation) {
    this.nextLocation = nextLocation;
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

  public Double getGrossWeight() {
    return grossWeight;
  }

  public void setGrossWeight(Double grossWeight) {
    this.grossWeight = grossWeight;
  }

  public WeightUnit getGrossWeightUnit() {
    return grossWeightUnit;
  }

  public void setGrossWeightUnit(WeightUnit grossWeightUnit) {
    this.grossWeightUnit = grossWeightUnit;
  }

  public EquipmentCondition getContainerCondition() {
    return containerCondition;
  }

  public void setContainerCondition(EquipmentCondition containerCondition) {
    this.containerCondition = containerCondition;
  }

  public Boolean getHazardIndicator() {
    return hazardIndicator;
  }

  public void setHazardIndicator(Boolean hazardIndicator) {
    this.hazardIndicator = hazardIndicator;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getContraAction() {
    return contraAction;
  }

  public void setContraAction(String contraAction) {
    this.contraAction = contraAction;
  }

  public String getPositionAtRoute() {
    return positionAtRoute;
  }

  public void setPositionAtRoute(String positionAtRoute) {
    this.positionAtRoute = positionAtRoute;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getContainerCheckDigit() {
    return containerCheckDigit;
  }

  public void setContainerCheckDigit(String containerCheckDigit) {
    this.containerCheckDigit = containerCheckDigit;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Timestamp getRecordUpdateDateTime() {
    return recordUpdateDateTime;
  }

  public void setRecordUpdateDateTime(Timestamp recordUpdateDateTime) {
    this.recordUpdateDateTime = recordUpdateDateTime;
  }
}
