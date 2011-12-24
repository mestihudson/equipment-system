package equipment.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import equipment.dao.ContainerIsoTypeDao;
import equipment.domain.entity.ContainerIsoType;

@Service("containerIsoTypeService")
public class ContainerIsoTypeServiceImpl implements ContainerIsoTypeService, InitializingBean {
  Map<String, ContainerIsoType> isoGroupMaps = new TreeMap<String, ContainerIsoType>();

  @Resource(name = "containerIsoTypeDao")
  private ContainerIsoTypeDao containerIsoTypeDao;

  @Override
  public void afterPropertiesSet() throws Exception {
    List<ContainerIsoType> types = containerIsoTypeDao.findAll();
    for (ContainerIsoType type : types) {
      isoGroupMaps.put(type.getIsoCode(), type);
    }
  }

  @Override
  public Set<String> getAllIsoCodes() {
    return isoGroupMaps.keySet();
  }

  @Override
  public Set<String> getAllGroupCodes() {
    Set<String> groupCodes = new TreeSet<>();
    for (ContainerIsoType type : isoGroupMaps.values()) {
      groupCodes.add(type.getGroupCode());
    }
    return groupCodes;
  }

  @Override
  public String getGroupByIso() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> getIsoByGroup() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<ContainerIsoType> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
