package equipment.service;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
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
    Collection<ContainerIsoType> types = containerIsoTypeDao.findAll();
    for (ContainerIsoType type : types) {
      isoGroupMaps.put(type.getIsoCode(), type);
    }
  }

  @Override
  public Collection<String> getAllIsoCodes() {
    return isoGroupMaps.keySet();
  }

  @Override
  public Collection<String> getAllGroupCodes() {
    Set<String> groupCodes = new TreeSet<String>();
    for (ContainerIsoType type : isoGroupMaps.values()) {
      groupCodes.add(type.getGroupCode());
    }
    return groupCodes;
  }

  @Override
  public String getGroupByIso(String isoCode) {
    if(isoGroupMaps.containsKey(isoCode)) {
      return isoGroupMaps.get(isoCode).getGroupCode();
    } else {
      return null;
    }
  }

  @Override
  public Collection<String> getIsoByGroup(String groupCode) {
    Set<String> isoCodes = new TreeSet<String>();
    for(Entry<String, ContainerIsoType> entry:isoGroupMaps.entrySet()) {
      if(entry.getValue().getGroupCode().equals(groupCode)) {
        isoCodes.add(entry.getKey());
      }
    }
    return isoCodes;
  }

  @Override
  public Collection<ContainerIsoType> getAll() {
    return containerIsoTypeDao.findAll();
  }

}
