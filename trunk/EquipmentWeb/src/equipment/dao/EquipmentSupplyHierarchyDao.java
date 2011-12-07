package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.EquipmentSupplyHierarchy;

@Repository("equipmentSupplyHierarchyDao")
public class EquipmentSupplyHierarchyDao extends AbstractBaseDao {

  public static final String FACILITY = "facility";

  @Override
  public Class<?> getDomainClass() {
    return EquipmentSupplyHierarchy.class;
  }
  
}