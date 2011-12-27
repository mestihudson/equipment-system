package equipment.service;

import equipment.domain.entity.EquipmentLatestInfo;

public interface EquipmentLatestInfoService {
  EquipmentLatestInfo findByContainerNumber(String containerNumber);
}
