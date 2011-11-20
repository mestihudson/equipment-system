package equipment.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.EquipmentEventDao;

@Service("equipmentEventService")
@Scope("singleton")
@Transactional
public class EquipmentEventServiceImpl extends EquipmentEventDao implements EquipmentEventService {
	
}
