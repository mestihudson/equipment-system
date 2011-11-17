package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.EquipmentSupplyHierarchy;

@Repository("equipmentSupplyHierarchyDao")
public class EquipmentSupplyHierarchyDao extends AbstractBaseDao {

  public static final String FCIL_CDE = "facilityCode";

  @Override
  public Class<?> getDomainClass() {
    return EquipmentSupplyHierarchy.class;
  }
  
}
