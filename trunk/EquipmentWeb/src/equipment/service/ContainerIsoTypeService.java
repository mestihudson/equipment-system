package equipment.service;

import java.util.Collection;

import equipment.domain.entity.ContainerIsoType;

public interface ContainerIsoTypeService {
  Collection<String> getAllIsoCodes();
  Collection<String> getAllGroupCodes();
  String getGroupByIso(String isoCode);
  Collection<String> getIsoByGroup(String groupCode);
  Collection<ContainerIsoType> getAll();
}
