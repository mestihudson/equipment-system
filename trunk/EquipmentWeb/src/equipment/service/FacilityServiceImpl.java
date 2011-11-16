package equipment.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.domain.Facility;

@Component("facilityService")
@Scope("singleton")
public class FacilityServiceImpl implements FacilityService {

	@Resource(name = "sessionFactory")
	public SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Facility.class);
		List<Facility> facilities = criteria.list();
		List<String> codes = new ArrayList<String>();
		for(Facility facility : facilities) {
			codes.add(facility.getCode());
		}
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findFacilityCodesStartWith(String query) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Facility.class);
		criteria.add(Restrictions.like(Facility.FCIL_CDE, query + "%").ignoreCase()).setProjection(Property.forName(Facility.FCIL_CDE));
		return criteria.list();
	}

	@Override
	public void save(Facility facility){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(facility);
		session.getTransaction().commit();
	}
	
}
