package equipment.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
	private Timestamp eventCreationDateTime;

	@Column(name = "BATCH_REF")
	private String batchReference;

	@Column(name = "PIN")
	private String pin;

	@Column(name = "FCIL_CDE")
	private String facilityCode;

	@Column(name = "EVENT_TYPE")
	@Type(type = "equipment.utils.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "equipment.domain.enums.EventType"),
			@Parameter(name = "identifierMethod", value = "getCode"),
			@Parameter(name = "valueOfMethod", value = "getEventTypeForCode") })
	private EventType eventType;

	@Column(name = "EVENT_DT_LOC")
	private Timestamp eventDateTimeLocal;

	@Column(name = "EVENT_DT_GMT")
	private Timestamp eventDateTimeGmt;

	@Column(name = "SEAL_NUM")
	private String sealNumber;

	@Column(name = "SEAL_TYPE")
	private String sealType;

	@Column(name = "CHASSIS_NUM")
	private String chassisNumber;

	@Column(name = "CHASSIS_LINK_IND")
	private String chassisLinkIndicator;

	@Column(name = "CHASSIS_CTRL_TYPE")
	private String chassisControlType;

	@Column(name = "GENSET_NUM")
	private String gensetNumber;

	@Column(name = "CNTR_TYPE_OOCL_CDE")
	private String containerTypeOoclCode;

	@Column(name = "CHASSIS_TYPE_GRP_CDE")
	private String chassisTypeGroupCode;

	@Column(name = "GENSET_TYPE_CDE")
	private String gensetTypeCode;

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

	@Column(name = "NEXT_SVC_LOOP")
	private String nextServiceLoop;

	@Column(name = "NEXT_VSL_CDE")
	private String nextVesselCode;

	@Column(name = "NEXT_VOY_NUM")
	private String nextVoyageNumber;

	@Column(name = "NEXT_DIR_BOUND")
	private String nextDirectionBound;

	@Column(name = "LOAD_PORT")
	private String loadPort;

	@Column(name = "DSGH_PORT")
	private String dischargePort;

	@Column(name = "ULTI_LOCA")
	private String ultimateLocation;

	@Column(name = "NEXT_LOCA")
	private String nextLocation;

	@Column(name = "DOC_REF")
	private String documentReference;

	@Column(name = "DOC_TYPE")
	private String documentType;

	@Column(name = "TO_DOC_REF")
	private String toDocumentReference;

	@Column(name = "TO_DOC_TYPE")
	private String toDocumentType;

	@Column(name = "INTERNAL_SHMT_NUM")
	private String internalShipmentNumber;

	// TODO
	@Column(name = "REPACK_IND")
	private String repackIndicator;

	@Column(name = "REPACK_CNTR_NUM")
	private String repackContainerNumber;

	@Column(name = "GROSS_WT")
	private Double grossWeight;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "GROSS_WT_UNIT")
	private WeightUnit grossWeightUnit;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "CNTR_COND")
	private EquipmentCondition containerCondition;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "CHASSIS_COND")
	private EquipmentCondition chassisCondition;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "GENSET_COND")
	private EquipmentCondition gensetCondition;

	@Column(name = "HZ_IND")
	private Boolean hazardIndicator;

	@Column(name = "CARRIER_ID")
	private String carrierId;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "RAIL_ID")
	private String railId;

	@Column(name = "STOWAGE_NUM")
	private String stowageNumber;

	@Column(name = "CHASSIS_POOL")
	private String chassisPool;

	@Column(name = "CHASSIS_OWNER")
	private String chassisOwner;

	@Column(name = "CHASSIS_OPERATOR")
	private String chassisOperator;

	@Column(name = "CONTRA_ACTION")
	private String contraAction;

	@Column(name = "PARKING_LOT_IND")
	private String parkingLotIndicator;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CNTR_CTRL_PARTY")
	private String containerControlParty;

	@Column(name = "CHASSIS_CTRL_PARTY")
	private String chassisControlParty;

	@Column(name = "GENSET_CTRL_PARTY")
	private String gensetControlParty;

	@Column(name = "USAGE_COND")
	private String usageCondition;

	@Column(name = "USAGE_SUB_COND")
	private String usageSubCondition;

	@Column(name = "CNTR_ASSN")
	private String containerAssociation;

	@Column(name = "CHASSIS_ASSN")
	private String chassisAssociation;

	@Column(name = "GENSET_ASSN")
	private String gensetAssociation;

	@Column(name = "POS_AT_ROUTE")
	private String positionAtRoute;

	@Column(name = "TRANSP_MODE")
	private String transportMode;

	@Column(name = "NATURE")
	private String nature;

	@Column(name = "CNTR_STATE_STATUS")
	private String containerStateStatus;

	@Column(name = "CHASSIS_STATE_STATUS")
	private String chassisStateStatus;

	@Column(name = "GENSET_STATE_STATUS")
	private String gensetStateStatus;

	@Column(name = "CNTR_RELATNSHP_STATUS")
	private String containerRelationshipStatus;

	@Column(name = "CHASSIS_RELATNSHP_STATUS")
	private String chassisRelationshipStatus;

	@Column(name = "GENSET_RELATNSHP_STATUS")
	private String gensetRelationshipStatus;

	@Column(name = "CNTR_RST_USE_SET_UUID")
	private BigDecimal containerRstUseSetUuid;

	@Column(name = "CHASSIS_RST_USE_SET_UUID")
	private BigDecimal chassisRstUseSetUuid;

	@Column(name = "GENSET_RST_USE_SET_UUID")
	private BigDecimal gensetRstUseSetUuid;

	@Column(name = "CNTR_CHK_DIGIT")
	private String containerCheckDigit;

	@Column(name = "ANCILLIARY_LOC")
	private String ancilliaryLocation;

	@Column(name = "UPD_DT_GMT")
	private Timestamp updateDateTimeGmt;

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

	public Timestamp getEventCreationDateTime() {
		return eventCreationDateTime;
	}

	public void setEventCreationDateTime(Timestamp eventCreationDateTime) {
		this.eventCreationDateTime = eventCreationDateTime;
	}

	public String getBatchReference() {
		return batchReference;
	}

	public void setBatchReference(String batchReference) {
		this.batchReference = batchReference;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
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

	public Timestamp getEventDateTimeLocal() {
		return eventDateTimeLocal;
	}

	public void setEventDateTimeLocal(Timestamp eventDateTimeLocal) {
		this.eventDateTimeLocal = eventDateTimeLocal;
	}

	public Timestamp getEventDateTimeGmt() {
		return eventDateTimeGmt;
	}

	public void setEventDateTimeGmt(Timestamp eventDateTimeGmt) {
		this.eventDateTimeGmt = eventDateTimeGmt;
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

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getChassisLinkIndicator() {
		return chassisLinkIndicator;
	}

	public void setChassisLinkIndicator(String chassisLinkIndicator) {
		this.chassisLinkIndicator = chassisLinkIndicator;
	}

	public String getChassisControlType() {
		return chassisControlType;
	}

	public void setChassisControlType(String chassisControlType) {
		this.chassisControlType = chassisControlType;
	}

	public String getGensetNumber() {
		return gensetNumber;
	}

	public void setGensetNumber(String gensetNumber) {
		this.gensetNumber = gensetNumber;
	}

	public String getContainerTypeOoclCode() {
		return containerTypeOoclCode;
	}

	public void setContainerTypeOoclCode(String containerTypeOoclCode) {
		this.containerTypeOoclCode = containerTypeOoclCode;
	}

	public String getChassisTypeGroupCode() {
		return chassisTypeGroupCode;
	}

	public void setChassisTypeGroupCode(String chassisTypeGroupCode) {
		this.chassisTypeGroupCode = chassisTypeGroupCode;
	}

	public String getGensetTypeCode() {
		return gensetTypeCode;
	}

	public void setGensetTypeCode(String gensetTypeCode) {
		this.gensetTypeCode = gensetTypeCode;
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

	public String getNextServiceLoop() {
		return nextServiceLoop;
	}

	public void setNextServiceLoop(String nextServiceLoop) {
		this.nextServiceLoop = nextServiceLoop;
	}

	public String getNextVesselCode() {
		return nextVesselCode;
	}

	public void setNextVesselCode(String nextVesselCode) {
		this.nextVesselCode = nextVesselCode;
	}

	public String getNextVoyageNumber() {
		return nextVoyageNumber;
	}

	public void setNextVoyageNumber(String nextVoyageNumber) {
		this.nextVoyageNumber = nextVoyageNumber;
	}

	public String getNextDirectionBound() {
		return nextDirectionBound;
	}

	public void setNextDirectionBound(String nextDirectionBound) {
		this.nextDirectionBound = nextDirectionBound;
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

	public String getUltimateLocation() {
		return ultimateLocation;
	}

	public void setUltimateLocation(String ultimateLocation) {
		this.ultimateLocation = ultimateLocation;
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

	public String getToDocumentReference() {
		return toDocumentReference;
	}

	public void setToDocumentReference(String toDocumentReference) {
		this.toDocumentReference = toDocumentReference;
	}

	public String getToDocumentType() {
		return toDocumentType;
	}

	public void setToDocumentType(String toDocumentType) {
		this.toDocumentType = toDocumentType;
	}

	public String getInternalShipmentNumber() {
		return internalShipmentNumber;
	}

	public void setInternalShipmentNumber(String internalShipmentNumber) {
		this.internalShipmentNumber = internalShipmentNumber;
	}

	public String getRepackIndicator() {
		return repackIndicator;
	}

	public void setRepackIndicator(String repackIndicator) {
		this.repackIndicator = repackIndicator;
	}

	public String getRepackContainerNumber() {
		return repackContainerNumber;
	}

	public void setRepackContainerNumber(String repackContainerNumber) {
		this.repackContainerNumber = repackContainerNumber;
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

	public EquipmentCondition getChassisCondition() {
		return chassisCondition;
	}

	public void setChassisCondition(EquipmentCondition chassisCondition) {
		this.chassisCondition = chassisCondition;
	}

	public EquipmentCondition getGensetCondition() {
		return gensetCondition;
	}

	public void setGensetCondition(EquipmentCondition gensetCondition) {
		this.gensetCondition = gensetCondition;
	}

	public Boolean getHazardIndicator() {
		return hazardIndicator;
	}

	public void setHazardIndicator(Boolean hazardIndicator) {
		this.hazardIndicator = hazardIndicator;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRailId() {
		return railId;
	}

	public void setRailId(String railId) {
		this.railId = railId;
	}

	public String getStowageNumber() {
		return stowageNumber;
	}

	public void setStowageNumber(String stowageNumber) {
		this.stowageNumber = stowageNumber;
	}

	public String getChassisPool() {
		return chassisPool;
	}

	public void setChassisPool(String chassisPool) {
		this.chassisPool = chassisPool;
	}

	public String getChassisOwner() {
		return chassisOwner;
	}

	public void setChassisOwner(String chassisOwner) {
		this.chassisOwner = chassisOwner;
	}

	public String getChassisOperator() {
		return chassisOperator;
	}

	public void setChassisOperator(String chassisOperator) {
		this.chassisOperator = chassisOperator;
	}

	public String getContraAction() {
		return contraAction;
	}

	public void setContraAction(String contraAction) {
		this.contraAction = contraAction;
	}

	public String getParkingLotIndicator() {
		return parkingLotIndicator;
	}

	public void setParkingLotIndicator(String parkingLotIndicator) {
		this.parkingLotIndicator = parkingLotIndicator;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContainerControlParty() {
		return containerControlParty;
	}

	public void setContainerControlParty(String containerControlParty) {
		this.containerControlParty = containerControlParty;
	}

	public String getChassisControlParty() {
		return chassisControlParty;
	}

	public void setChassisControlParty(String chassisControlParty) {
		this.chassisControlParty = chassisControlParty;
	}

	public String getGensetControlParty() {
		return gensetControlParty;
	}

	public void setGensetControlParty(String gensetControlParty) {
		this.gensetControlParty = gensetControlParty;
	}

	public String getUsageCondition() {
		return usageCondition;
	}

	public void setUsageCondition(String usageCondition) {
		this.usageCondition = usageCondition;
	}

	public String getUsageSubCondition() {
		return usageSubCondition;
	}

	public void setUsageSubCondition(String usageSubCondition) {
		this.usageSubCondition = usageSubCondition;
	}

	public String getContainerAssociation() {
		return containerAssociation;
	}

	public void setContainerAssociation(String containerAssociation) {
		this.containerAssociation = containerAssociation;
	}

	public String getChassisAssociation() {
		return chassisAssociation;
	}

	public void setChassisAssociation(String chassisAssociation) {
		this.chassisAssociation = chassisAssociation;
	}

	public String getGensetAssociation() {
		return gensetAssociation;
	}

	public void setGensetAssociation(String gensetAssociation) {
		this.gensetAssociation = gensetAssociation;
	}

	public String getPositionAtRoute() {
		return positionAtRoute;
	}

	public void setPositionAtRoute(String positionAtRoute) {
		this.positionAtRoute = positionAtRoute;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getContainerStateStatus() {
		return containerStateStatus;
	}

	public void setContainerStateStatus(String containerStateStatus) {
		this.containerStateStatus = containerStateStatus;
	}

	public String getChassisStateStatus() {
		return chassisStateStatus;
	}

	public void setChassisStateStatus(String chassisStateStatus) {
		this.chassisStateStatus = chassisStateStatus;
	}

	public String getGensetStateStatus() {
		return gensetStateStatus;
	}

	public void setGensetStateStatus(String gensetStateStatus) {
		this.gensetStateStatus = gensetStateStatus;
	}

	public String getContainerRelationshipStatus() {
		return containerRelationshipStatus;
	}

	public void setContainerRelationshipStatus(
			String containerRelationshipStatus) {
		this.containerRelationshipStatus = containerRelationshipStatus;
	}

	public String getChassisRelationshipStatus() {
		return chassisRelationshipStatus;
	}

	public void setChassisRelationshipStatus(String chassisRelationshipStatus) {
		this.chassisRelationshipStatus = chassisRelationshipStatus;
	}

	public String getGensetRelationshipStatus() {
		return gensetRelationshipStatus;
	}

	public void setGensetRelationshipStatus(String gensetRelationshipStatus) {
		this.gensetRelationshipStatus = gensetRelationshipStatus;
	}

	public BigDecimal getContainerRstUseSetUuid() {
		return containerRstUseSetUuid;
	}

	public void setContainerRstUseSetUuid(BigDecimal containerRstUseSetUuid) {
		this.containerRstUseSetUuid = containerRstUseSetUuid;
	}

	public BigDecimal getChassisRstUseSetUuid() {
		return chassisRstUseSetUuid;
	}

	public void setChassisRstUseSetUuid(BigDecimal chassisRstUseSetUuid) {
		this.chassisRstUseSetUuid = chassisRstUseSetUuid;
	}

	public BigDecimal getGensetRstUseSetUuid() {
		return gensetRstUseSetUuid;
	}

	public void setGensetRstUseSetUuid(BigDecimal gensetRstUseSetUuid) {
		this.gensetRstUseSetUuid = gensetRstUseSetUuid;
	}

	public String getContainerCheckDigit() {
		return containerCheckDigit;
	}

	public void setContainerCheckDigit(String containerCheckDigit) {
		this.containerCheckDigit = containerCheckDigit;
	}

	public String getAncilliaryLocation() {
		return ancilliaryLocation;
	}

	public void setAncilliaryLocation(String ancilliaryLocation) {
		this.ancilliaryLocation = ancilliaryLocation;
	}

	public Timestamp getUpdateDateTimeGmt() {
		return updateDateTimeGmt;
	}

	public void setUpdateDateTimeGmt(Timestamp updateDateTimeGmt) {
		this.updateDateTimeGmt = updateDateTimeGmt;
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
