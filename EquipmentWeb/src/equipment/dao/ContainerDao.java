package equipment.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import equipment.domain.Container;

@Repository("containerDao")
@Scope("singleton")
public class ContainerDao {

  @Resource(name = "sessionFactory")
  public SessionFactory sessionFactory;
  
  public void save(Container container) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(container);
    session.getTransaction().commit();
  }
}
