package equipment.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
abstract class AbstractBaseDao {

  @Resource(name = "sessionFactory")
  protected SessionFactory sessionFactory;

  protected SessionFactory getSessionFactory() {
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
  
  public void saveOrUpdate(Object o) {
    getCurrentSession().saveOrUpdate(o);
  }
  
  public void update(Object o) {
    getCurrentSession().update(o);
  }

  public void delete(Object o) {
    getCurrentSession().delete(o);
  }

  public void evict(Object o) {
    getCurrentSession().evict(o);
  }

  @SuppressWarnings("unchecked")
//  @PreAuthorize("hasRole('System Administrator')")
  public <T> List<T> findAll() {
    return createCriteria().list();
  }

  @SuppressWarnings("unchecked")
  public <T> T findById(Serializable o) {
    List<T> results = createCriteria().add(Restrictions.idEq(o)).list();
    if (results.isEmpty()) {
      return null;
    } else {
      return results.get(0);
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T load(Serializable o) {
    return (T) getCurrentSession().load(getDomainClass(), o);
  }

  @SuppressWarnings("unchecked")
  public <T> List<T> findBy(Map<String, Object> propertyNameValues) {
    return createCriteria().add(Restrictions.allEq(propertyNameValues)).list();
  }

  @SuppressWarnings("unchecked")
  public <T> List<T> find(SimpleSearchCriteria simpleSearchCriteria) {
    Criteria criteria = createCriteria();
    Iterator<Criterion> criterions = simpleSearchCriteria.iterator();
    while(criterions.hasNext()) {
      criteria.add(criterions.next());
    }
    for(Order o : simpleSearchCriteria.getOrders()) {
      criteria.addOrder(o);
    }
    if(simpleSearchCriteria.getFetchSize() != null) {
      criteria.setFetchSize(simpleSearchCriteria.getFetchSize());
    }
    if(simpleSearchCriteria.getFirstResult() != null) {
      criteria.setFirstResult(simpleSearchCriteria.getFirstResult());
    }
    if(simpleSearchCriteria.getMaxResults() != null) {
      criteria.setMaxResults(simpleSearchCriteria.getMaxResults());
    }
    if(simpleSearchCriteria.getTimeout() != null) {
      criteria.setTimeout(simpleSearchCriteria.getTimeout());
    }
    return criteria.list();
  }
  
  public <T> T findFirst(SimpleSearchCriteria simpleSearchCriteria) {
    simpleSearchCriteria.setMaxResults(1);
    List<T> results = find(simpleSearchCriteria);
    if(results.isEmpty()) {
      return null;
    } else {
      return results.get(0);
    }
  }
  
  public Object callNamedQuery(String sql, Map<String, Object> parameter) {
    Query query = getCurrentSession().createSQLQuery(sql);
    for(Entry<String, Object> entry:parameter.entrySet()){
      query.setParameter(entry.getKey(), entry.getValue());
    }
    return query.executeUpdate();
  }
}
