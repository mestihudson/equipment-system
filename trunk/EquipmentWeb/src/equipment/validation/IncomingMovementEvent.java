package equipment.validation;

import equipment.domain.enums.Direction;
import equipment.domain.enums.EquipmentCondition;
import equipment.domain.enums.LoadEmptyIndicator;
import equipment.domain.enums.WeightUnit;

public class IncomingMovementEvent extends IncomingEvent {
  private static final long serialVersionUID = 1185169475757708326L;
  private String sealNumber;
  private String sealType;
  private String containerGroupCode;
  private LoadEmptyIndicator loadEmptyIndicator;
  private String serviceLoop;
  private String vesselCode;
  private String voyageNumber;
  private Direction directionBound;
  private String loadPort;
  private String dischargePort;
  private String nextLocation;
  private String documentReference;
  private String documentType;
  private Double grossWeight;
  private WeightUnit grossWeightUnit;
  private EquipmentCondition containerCondition;
  private Boolean hazardIndicator;
  private String remarks;
  private String contraAction;
  private String positionAtRoute;
  private String nature;
  private String containerCheckDigit;
  private String updateUser;
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
  public String getContainerNumber() {
    return getEquipmentNumber();
  }
  public void setContainerNumber(String containerNumber) {
    super.setEquipmentNumber(containerNumber);
  }
}
