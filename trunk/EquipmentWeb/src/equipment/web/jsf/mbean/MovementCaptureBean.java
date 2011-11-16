package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.ContainerDao;
import equipment.domain.Container;
import equipment.domain.EquipmentEvent;
import equipment.domain.enums.Direction;
import equipment.domain.enums.DocumentType;
import equipment.domain.enums.EquipmentCondition;
import equipment.domain.enums.EventType;
import equipment.domain.enums.LoadEmptyIndicator;
import equipment.domain.enums.WeightUnit;
import equipment.service.EquipmentEventService;
import equipment.service.FacilityService;

@Component("movementCaptureBean")
@Scope("request")
public class MovementCaptureBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource(name="equipmentEventService")
	private EquipmentEventService equipmentEventService;
	
	@Resource(name="containerDao")
	private ContainerDao containerDao;
	
	EquipmentEvent equipmentEvent;
	
	public EquipmentEvent getEquipmentEvent(){
		if(equipmentEvent == null) {
			equipmentEvent = new EquipmentEvent();
		}
		return equipmentEvent;
	}
	
	private String containerNumber;
	private EquipmentCondition containerCondition;
	private String chassisNumber;
	private EquipmentCondition chassisCondition;
	private String gensetNumber;
	private EquipmentCondition gensetCondition;
	private String facilityCode;
	private String nextLocation;
	private LoadEmptyIndicator loadEmptyIndicator;
	private EventType eventType;
	private double grossWeight;
	private WeightUnit weightUnit;
	private DocumentType documentType;
	private String documentReference;
	private String sealNumber;
	private String sealType;
	private String vesselCode;
	private String voyageNumber;
	private Direction direction;
	private Boolean hazardIndicator;
	private String loadPort;
	private String dischargePort;
	private String carrierId;
	private String railId;
	private String chassisPool;
	private String chassisOwner;
	private String chassisTypeGroupCode;
	private String chassisOperator;
	private String repackContainerNumber;
	private String remarks;
	
	@Resource(name = "facilityService")
	private FacilityService facilityService;

	public EnumSet<WeightUnit> getWeightUnits() {
		return EnumSet.allOf(WeightUnit.class);
	}
	
	public EnumSet<EventType> getEventTypes() {
		return EnumSet.of(EventType.ISSUE, EventType.RECEIVE,
				EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
				EventType.VANNING, EventType.REPACK, EventType.UNLINK,
				EventType.LINK, EventType.STATUS_CHANGE);
	}

	public EnumSet<LoadEmptyIndicator> getLoadEmptyIndicators() {
		return EnumSet.allOf(LoadEmptyIndicator.class);
	}

	public EnumSet<EquipmentCondition> getEquipmentConditions() {
		return EnumSet.allOf(EquipmentCondition.class);
	}

	public SelectItem[] getEquipmentConditionsWithNull() {
		SelectItem[] items = new SelectItem[EquipmentCondition.values().length + 1];
		items[0] = new SelectItem(null, "N/A");
		int i = 1;
		for (EquipmentCondition equipmentCondition : EquipmentCondition
				.values()) {
			items[i++] = new SelectItem(equipmentCondition,
					equipmentCondition.getDescription());
		}
		return items;
	}
	
	public EnumSet<DocumentType> getDocumentTypes() {
		return EnumSet.of(DocumentType.BM,DocumentType.BN,DocumentType.EP);
	}
	
	public EnumSet<Direction> getDirections() {
		return EnumSet.allOf(Direction.class);
	}
	
	public List<String> completeFacility(String query) {
		if(query.length() > 0 && query.length() < 5) {
			return facilityService.findFacilityCodesStartWith(query);
		}
		return null;
	}

	public void save() {
		System.out.println("Start save");
		getEquipmentEvent().setEventTimestamp(String.valueOf(System.currentTimeMillis()));
		getEquipmentEvent().setEventCreationDateTime(new Timestamp(System.currentTimeMillis()));
		getEquipmentEvent().setEventDateTimeLocal(new Timestamp(System.currentTimeMillis()));
		getEquipmentEvent().setPin("");
		equipmentEventService.save(getEquipmentEvent());
		Container container = new Container();
		container.setEquipmentNumber("CBHU1234567");
		container.setIsoCode("20H1");
		container.setGroupCode("20GP");
		container.setState(true);
		container.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
    container.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
		containerDao.save(container);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Save Successful"));  
	}
	
	public String getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getNextLocation() {
		return nextLocation;
	}

	public void setNextLocation(String nextLocation) {
		this.nextLocation = nextLocation;
	}

	public LoadEmptyIndicator getLoadEmptyIndicator() {
		return loadEmptyIndicator;
	}

	public void setLoadEmptyIndicator(LoadEmptyIndicator loadEmptyIndicator) {
		this.loadEmptyIndicator = loadEmptyIndicator;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public WeightUnit getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(WeightUnit weightUnit) {
		this.weightUnit = weightUnit;
	}

	public FacilityService getFacilityService() {
		return facilityService;
	}

	public void setFacilityService(FacilityService facilityService) {
		this.facilityService = facilityService;
	}

	public void setContainerCondition(EquipmentCondition containerCondition) {
		this.containerCondition = containerCondition;
	}

	public EquipmentCondition getContainerCondition() {
		return containerCondition;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}

	public String getDocumentReference() {
		return documentReference;
	}

	public void setSealNumber(String sealNumber) {
		this.sealNumber = sealNumber;
	}

	public String getSealNumber() {
		return sealNumber;
	}

	public void setSealType(String sealType) {
		this.sealType = sealType;
	}

	public String getSealType() {
		return sealType;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setHazardIndicator(Boolean hazardIndicator) {
		this.hazardIndicator = hazardIndicator;
	}

	public Boolean getHazardIndicator() {
		return hazardIndicator;
	}

	public void setLoadPort(String loadPort) {
		this.loadPort = loadPort;
	}

	public String getLoadPort() {
		return loadPort;
	}

	public void setDischargePort(String dischargePort) {
		this.dischargePort = dischargePort;
	}

	public String getDischargePort() {
		return dischargePort;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setRailId(String railId) {
		this.railId = railId;
	}

	public String getRailId() {
		return railId;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public EquipmentCondition getChassisCondition() {
		return chassisCondition;
	}

	public void setChassisCondition(EquipmentCondition chassisCondition) {
		this.chassisCondition = chassisCondition;
	}

	public String getGensetNumber() {
		return gensetNumber;
	}

	public void setGensetNumber(String gensetNumber) {
		this.gensetNumber = gensetNumber;
	}

	public EquipmentCondition getGensetCondition() {
		return gensetCondition;
	}

	public void setGensetCondition(EquipmentCondition gensetCondition) {
		this.gensetCondition = gensetCondition;
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

	public String getChassisTypeGroupCode() {
		return chassisTypeGroupCode;
	}

	public void setChassisTypeGroupCode(String chassisTypeGroupCode) {
		this.chassisTypeGroupCode = chassisTypeGroupCode;
	}

	public String getChassisOperator() {
		return chassisOperator;
	}

	public void setChassisOperator(String chassisOperator) {
		this.chassisOperator = chassisOperator;
	}

	public void setRepackContainerNumber(String repackContainerNumber) {
		this.repackContainerNumber = repackContainerNumber;
	}

	public String getRepackContainerNumber() {
		return repackContainerNumber;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}
	
}
