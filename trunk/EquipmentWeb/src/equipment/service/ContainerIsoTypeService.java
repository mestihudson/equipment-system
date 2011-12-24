package equipment.service;

import java.util.Set;

import equipment.domain.entity.ContainerIsoType;

public interface ContainerIsoTypeService {
  Set<String> getAllIsoCodes();
  Set<String> getAllGroupCodes();
  String getGroupByIso();
  Set<String> getIsoByGroup();
  Set<ContainerIsoType> getAll();
}
