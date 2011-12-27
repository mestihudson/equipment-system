package equipment.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.EquipmentLatestInfo;

@Repository("equipmentLatestInfoDao")
public class EquipmentLatestInfoDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return EquipmentLatestInfo.class;
  }
  
  public EquipmentLatestInfo findByContainerNumber(String containerNumber){
    return findById(getDomainClass());
  }
}
