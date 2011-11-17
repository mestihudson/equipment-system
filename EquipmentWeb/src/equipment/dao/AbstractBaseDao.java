package equipment.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
abstract class AbstractBaseDao {

  @Resource(name = "sessionFactory")
  protected SessionFactory sessionFactory;

  protected  SessionFactory getSessionFactory(){
    return sessionFactory;
  }

  public abstract Class<?> getDomainClass();

  protected Session getCurrentSession() {
    return getSessionFactory().getCurrentSession();
  }

  public Criteria createCriteria() {
    return getCurrentSession().createCriteria(getDomainClass());
  }
  
  public void save(Object o) {
    getCurrentSession().save(o);
  }

  public void delete(Object o) {
    getCurrentSession().delete(o);
  }

  public void evict(Object o) {
    getCurrentSession().evict(o);
  }

  @SuppressWarnings("unchecked")
  public <T> List<T> findAll() {
    return getCurrentSession().createCriteria(getDomainClass()).list();
  }

  @SuppressWarnings("unchecked")
  public <T> T findById(Serializable o) {
    return (T) getCurrentSession().createCriteria(getDomainClass()).add(Restrictions.idEq(o));
  }
}
