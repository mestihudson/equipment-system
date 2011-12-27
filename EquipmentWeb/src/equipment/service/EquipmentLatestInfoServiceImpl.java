package equipment.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.dao.EquipmentLatestInfoDao;
import equipment.domain.entity.EquipmentLatestInfo;

@Service("EquipmentLatestInfoService")
@Scope("singleton")
public class EquipmentLatestInfoServiceImpl implements EquipmentLatestInfoService {

  @Resource(name = "EquipmentLatestInfoDao")
  private EquipmentLatestInfoDao equipmentLatestInfoDao;

  @Override
  public EquipmentLatestInfo findByContainerNumber(String containerNumber) {
    return equipmentLatestInfoDao.findByContainerNumber(containerNumber);
  }

}
