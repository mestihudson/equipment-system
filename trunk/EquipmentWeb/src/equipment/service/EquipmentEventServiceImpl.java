package equipment.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.EquipmentEventDao;
import equipment.dao.SimpleSearchCriteria;
import equipment.domain.entity.EquipmentEvent;

@Service("equipmentEventService")
@Transactional
public class EquipmentEventServiceImpl implements EquipmentEventService {
  @Resource(name = "equipmentEventDao")
  private EquipmentEventDao equipmentEventDao;

  @Override
  public EquipmentEvent findLastEventBeforeDate(String equipmentNumber, Date date) {
    SimpleSearchCriteria criteria = new SimpleSearchCriteria();
    criteria.addEqual(EquipmentEventDao.EQMT_NUM, equipmentNumber);
    criteria.addLessThan(EquipmentEventDao.EVENT_DT_LOC, date).setMaxResults(1);
    criteria.addOrder(Order.desc(EquipmentEventDao.EVENT_DT_LOC));
    return equipmentEventDao.findFirst(criteria);
  }

  @Override
  public List<EquipmentEvent> findByEquipmentNumber(String equipmentNumber) {
    SimpleSearchCriteria criteria = new SimpleSearchCriteria();
    criteria.addEqual(EquipmentEventDao.EQMT_NUM, equipmentNumber).addOrder(
        Order.desc(EquipmentEventDao.EVENT_DT_LOC));
    return equipmentEventDao.find(criteria);
  }
}
