package equipment.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import equipment.dao.EquipmentLatestInfoDao;
import equipment.domain.entity.EquipmentLatestInfo;

@Service("equipmentLatestInfoService")
public class EquipmentLatestInfoServiceImpl implements EquipmentLatestInfoService {

  @Resource(name = "equipmentLatestInfoDao")
  private EquipmentLatestInfoDao equipmentLatestInfoDao;

  @Override
  public EquipmentLatestInfo findByEquipmentNumber(String containerNumber) {
    return equipmentLatestInfoDao.get(containerNumber);
  }

}
