package equipment.domain.enums;

public enum ErrorMessage {
  EVENT_DATE_GREATER_THAN_CURRENT_DATE("001");

  private String code;

  private ErrorMessage(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
