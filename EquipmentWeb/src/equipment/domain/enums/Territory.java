package equipment.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Territory {
  APT,EUT,NAT;
  
  private static List<String> list;
  
  static{
    list = new ArrayList<String>();
    for(Territory territory : values()) {
      list.add(territory.name());
    }
  }
  
  public static List<String> getStringValue() {
    return list;
  }
}
