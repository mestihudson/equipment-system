package equipment.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.EquipmentEvent;

@Component("equipmentEventService")
@Scope("singleton")
public class EquipmentEventServiceImpl implements EquipmentEventService {
	
	@Resource(name = "sessionFactory")
	public SessionFactory sessionFactory;

	@Override
	public void save(EquipmentEvent equipmentEvent) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(equipmentEvent);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentEvent> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(EquipmentEvent.class);
		return criteria.list();
	}
}
