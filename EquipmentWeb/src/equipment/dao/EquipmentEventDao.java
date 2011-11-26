package equipment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import equipment.domain.EquipmentEvent;

@Repository("equipmentEventDao")
public class EquipmentEventDao extends AbstractBaseDao {
  private final static String CNTR_NUM = "containerNumber";

  @Override
  public Class<?> getDomainClass() {
    return EquipmentEvent.class;
  }

  public List<EquipmentEvent> findByContainerNumber(String containerNumber) {
    Map<String, Object> nameValue = new HashMap<String, Object>();
    nameValue.put(CNTR_NUM, containerNumber);
    return findBy(nameValue);
  }
}
