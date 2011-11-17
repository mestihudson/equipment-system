package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.EquipmentEvent;

@Repository("equipmentEventDao")
public class EquipmentEventDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return EquipmentEvent.class;
  }
  
}
