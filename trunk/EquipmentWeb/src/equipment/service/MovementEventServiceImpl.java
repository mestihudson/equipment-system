package equipment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.dao.MovementEventDao;
import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.ContraAction;

@Service("movementEventService")
@Scope("singleton")
public class MovementEventServiceImpl implements MovementEventService {

  @Resource(name = "movementEventDao")
  private MovementEventDao movementEventDao;

  @Override
  public int deleteEvents(MovementEvent[] events) {
    int count = 0;
    for(MovementEvent event : events) {
      event.setContraAction(ContraAction.DELETE);
      movementEventDao.update(event);
      count ++;
    }
    return count;
  }

  @Override
  public List<MovementEvent> findByContainerNumber(String containerNumber) {
    Map<String, Object> restrictionMap = new HashMap<String,Object> ();
    restrictionMap.put(MovementEventDao.CNTR_NUM, containerNumber);
	  return movementEventDao.findBy(restrictionMap);
  }

  @SuppressWarnings("unchecked")
  @Override
  public MovementEvent findLastEventBeforeDate(String containerNumber, Date date) {
    Criteria criteria = movementEventDao.createCriteria();
    criteria.add(Restrictions.eq(MovementEventDao.CNTR_NUM, containerNumber))
        .add(Restrictions.lt(MovementEventDao.EVENT_DT_LOC, date)).setMaxResults(1)
        .addOrder(Order.desc(MovementEventDao.EVENT_DT_LOC)).addOrder(Order.desc(MovementEventDao.EVENT_CRE_DT));
    List<MovementEvent> result = criteria.list();
    if (result == null || result.size() == 0) {
      return null;
    } else {
      return result.get(0);
    }
  }

@Override
public int removeEvents(MovementEvent[] selectedEvents) {
	int count=0;
	for(MovementEvent event : selectedEvents){
		Object obj =movementEventDao.get(event.getEventTimestamp());
		if(obj!=null){
		movementEventDao.delete(obj);
		count++;
		}
	}
	return count;
}
}
