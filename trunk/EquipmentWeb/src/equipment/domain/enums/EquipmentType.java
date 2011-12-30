package equipment.domain.enums;

public enum EquipmentType {
  CONTAINER("C"), CHASSIS("T"), GENSET("G");
  private String code;

  private EquipmentType(String code) {
    this.setCode(code);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static EquipmentType getEquipmentTypeForCode(String code) {
    if ("C".equals(code)) {
      return CONTAINER;
    } else if ("T".equals(code)) {
      return CHASSIS;
    } else if ("G".equals(code)) {
      return GENSET;
    } else {
      return null;
    }
  }
}
