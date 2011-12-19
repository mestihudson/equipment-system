package equipment.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.MovementEventDao;

@Service("movementEventService")
@Scope("singleton")
@Transactional
public class MovementEventServiceImpl extends MovementEventDao implements MovementEventService {
	
}
