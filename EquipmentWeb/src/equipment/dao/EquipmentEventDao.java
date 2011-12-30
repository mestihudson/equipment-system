package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.EquipmentEvent;

@Repository("equipmentEventDao")
public class EquipmentEventDao extends AbstractBaseDao {
  public static final String EQMT_NUM = "equipmentNumber";
  public static final String EVENT_DT_LOC = "eventDateTime";
  @Override
  public Class<?> getDomainClass() {
    return EquipmentEvent.class;
  }

}
