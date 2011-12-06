package equipment.domain.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum EventType   {
  DISCHARGE("02", "Discharge"),
  LOADING("03","Loading"),
  DEVANNING("04","Devanning"),
  VANNING("05","Vanning"),
  ISSUE("06","Issue"),
  RECEIVE("07","Receive"),
  REPACK("10","Repack"),
  CREATION("11","Creation"),
  TERMINATION("12","Termination"),
  UNLINK("13","Unlink"),
  LINK("14","Link"),
  POOL_ON("15","Pool on"),
  POOL_OFF("16","Pool off"),
  STATUS_CHANGE("17","Status change"),
  PHASE_IN("18","Phase in"),
  PHASE_OUT("19","Phase out"),
  TRANSFER("20","Transfer"),
  POOL_SWAP("21","Pool Swap");

  private static Map<String, EventType> eventTypes = new HashMap<String, EventType>();
  private static Set<String> externalSystemEventTypeCodes;

  static {
    for (EventType eventType : EventType.values()) {
      eventTypes.put(eventType.getCode(), eventType);
    }
    externalSystemEventTypeCodes = new HashSet<String>();
    externalSystemEventTypeCodes.add(ISSUE.getCode());
    externalSystemEventTypeCodes.add(RECEIVE.getCode());
    externalSystemEventTypeCodes.add(DISCHARGE.getCode());
    externalSystemEventTypeCodes.add(LOADING.getCode());
    externalSystemEventTypeCodes.add(DEVANNING.getCode());
    externalSystemEventTypeCodes.add(VANNING.getCode());
    externalSystemEventTypeCodes.add(REPACK.getCode());
    externalSystemEventTypeCodes.add(UNLINK.getCode());
    externalSystemEventTypeCodes.add(LINK.getCode());
    externalSystemEventTypeCodes.add(STATUS_CHANGE.getCode());
  }

  private String code;
  private String description;

  private EventType(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static boolean shouldSendToExternalSystem(String eventType) {
    return externalSystemEventTypeCodes.contains(eventType);  
  }

  public static String getDescriptionForCode(String code) {
    EventType eventType = getEventTypeForCode(code);
    return eventType == null ? "" : eventType.getDescription();
  }
  
  public static EventType getEventTypeForCode(String code) {
    return eventTypes.get(code);
  }

  public String getCode(){
    return code;
  }

  public String getDescription() {
    return description;
  }

  public static EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK, EventType.STATUS_CHANGE);
  }
}
