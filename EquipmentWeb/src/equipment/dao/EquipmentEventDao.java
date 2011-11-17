package equipment.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import equipment.domain.EquipmentEvent;

@Repository("equipmentEventDao")
public class EquipmentEventDao extends AbstractBaseDao {

  @Resource(name = "sessionFactory")
  public SessionFactory sessionFactory;
  
  @Override
  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  @Override
  public Class<?> getDomainClass() {
    return EquipmentEvent.class;
  }

  protected Session getCurrentSesion() {
    return getSessionFactory().getCurrentSession();
  }
  
}
