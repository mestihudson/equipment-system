package equipment.domain.enums;

public enum ContraAction {
  NEW("N"), DELETE("D"), EDIT("E");

  private String code;

  private ContraAction(String code) {
    this.setCode(code);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static ContraAction getContraActionForCode(String code) {
    if ("N".equals(code)) {
      return NEW;
    } else if ("D".equals(code)) {
      return DELETE;
    } else if ("E".equals(code)) {
      return EDIT;
    } else {
      return null;
    }
  }
}
