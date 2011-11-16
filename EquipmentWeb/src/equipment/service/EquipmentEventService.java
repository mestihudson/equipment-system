package equipment.service;

import java.util.List;

import equipment.domain.EquipmentEvent;

public interface EquipmentEventService {
	public void save(EquipmentEvent equipmentEvent);
	public List<EquipmentEvent> findAll();
}