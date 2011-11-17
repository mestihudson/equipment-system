package equipment.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import equipment.domain.Container;

@Repository("containerDao")
@Scope("singleton")
public class ContainerDao extends AbstractBaseDao {

  @Resource(name = "sessionFactory")
  public SessionFactory sessionFactory;

  @Override
  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  @Override
  public Class<?> getDomainClass() {
    return Container.class;
  }

}
