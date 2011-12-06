package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.EquipmentSupplyHierarchyDao;
import equipment.domain.entity.EquipmentSupplyHierarchy;

@Component("hierarchyBean")
@Scope("request")
public class HierarchyBean implements Serializable{
  @Resource(name="equipmentSupplyHierarchyDao")
  private EquipmentSupplyHierarchyDao equipmentSupplyHierarchyDao;

  public List<EquipmentSupplyHierarchy> getSupplyHierarchies() {
    return equipmentSupplyHierarchyDao.findAll();
  }
}
