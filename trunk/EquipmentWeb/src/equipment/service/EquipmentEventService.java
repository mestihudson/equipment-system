package equipment.service;

import java.util.Date;

import equipment.domain.entity.EquipmentEvent;

public interface EquipmentEventService {
  EquipmentEvent findLastEventBeforeDate(String equipmentNumber, Date date);
}
