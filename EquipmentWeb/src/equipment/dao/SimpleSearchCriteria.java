package equipment.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SimpleSearchCriteria {
  private List<Criterion> expressions = new ArrayList<Criterion>();
  private List<Order> orders = new ArrayList<Order>();

  private Integer maxResults;
  private Integer firstResult;
  private Integer timeout;
  private Integer fetchSize;
  
  public SimpleSearchCriteria add(Criterion expression) {
    expressions.add(expression);
    return this;
  }

  public SimpleSearchCriteria addOrder(Order order) {
    orders.add(order);
    return this;
  }
  
  public Iterator<Criterion> iterator() {
    return expressions.iterator();
  }

  public SimpleSearchCriteria addEqual(String propertyName, Object value) {
    expressions.add(Restrictions.eq(propertyName, value));
    return this;
  }
  
  public SimpleSearchCriteria addAllEqual(Map<String, Object> propertyNameValue) {
    expressions.add(Restrictions.allEq(propertyNameValue));
    return this;
  }

  public SimpleSearchCriteria addGreaterThan(String propertyName, Object value) {
    expressions.add(Restrictions.gt(propertyName, value));
    return this;
  }

  public SimpleSearchCriteria addGreaterEqual(String propertyName, Object value) {
    expressions.add(Restrictions.ge(propertyName, value));
    return this;
  }

  public SimpleSearchCriteria addLessThan(String propertyName, Object value) {
    expressions.add(Restrictions.lt(propertyName, value));
    return this;
  }

  public SimpleSearchCriteria addLessEqual(String propertyName, Object value) {
    expressions.add(Restrictions.le(propertyName, value));
    return this;
  }

  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public Integer getFirstResult() {
    return firstResult;
  }

  public void setFirstResult(Integer firstResult) {
    this.firstResult = firstResult;
  }

  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public Integer getFetchSize() {
    return fetchSize;
  }

  public void setFetchSize(Integer fetchSize) {
    this.fetchSize = fetchSize;
  }
  
  public List<Order> getOrders() {
    return orders;
  }
}
