package equipment.domain.enums;


public enum SubEventType {
  ON_HIRE("02", "On hire"),
  OFF_HIRE("03","Off hire"),
  PURCHASE("04","Purchase In"),
  SOLD("04","Sold Out"),
  SOC("04","Shipper Owned"),
  END_SOC("04","End Shipper Owned");

  private String code;
  private String description;
  
  private SubEventType(String code, String description) {
    this.setCode(code);
    this.setDescription(description);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
