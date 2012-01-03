package equipment.domain.enums;

public enum ErrorMessage {
  EVENT_DATE_GREATER_THAN_CURRENT_DATE("0001", "Event date greater than current date"),
  CONTAINER_NOT_EXISTS("0002", "Container does not exist"),
  CONTAINER_INACTIVE("0003", "Container is inactive"),
  FACILITY_NOT_EXISTS("0004", "Facility does not exist")
  ;

  private String code;
  private String description;

  private ErrorMessage(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
