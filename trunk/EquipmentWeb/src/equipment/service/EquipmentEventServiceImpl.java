package equipment.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import equipment.dao.EquipmentEventDao;
import equipment.domain.entity.EquipmentEvent;

@Service("equipmentEventService")
public class EquipmentEventServiceImpl implements EquipmentEventService {
  @Resource(name = "equipmentEventDao")
  private EquipmentEventDao equipmentEventDao;

  @SuppressWarnings("unchecked")
  @Override
  public EquipmentEvent findLastEventBeforeDate(String equipmentNumber, Date date) {
    Criteria criteria = equipmentEventDao.createCriteria();
    criteria.add(Restrictions.eq(EquipmentEventDao.EQMT_NUM, equipmentNumber))
        .add(Restrictions.lt(EquipmentEventDao.EVENT_DT_LOC, date)).setMaxResults(1)
        .addOrder(Order.desc(EquipmentEventDao.EVENT_DT_LOC));
    List<EquipmentEvent> result = criteria.list();
    if (result == null || result.size() == 0) {
      return null;
    } else {
      return result.get(0);
    }
  }
}
