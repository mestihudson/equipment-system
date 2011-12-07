package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.EquipmentSupplyHierarchyDao;
import equipment.domain.entity.EquipmentSupplyHierarchy;
import equipment.domain.enums.Territory;

@Component("hierarchyBean")
@Scope("request")
public class HierarchyBean implements Serializable {
  private static final long serialVersionUID = -5650490585039961293L;
  @Resource(name = "equipmentSupplyHierarchyDao")
  private EquipmentSupplyHierarchyDao equipmentSupplyHierarchyDao;

  public List<EquipmentSupplyHierarchy> getSupplyHierarchies() {
    return equipmentSupplyHierarchyDao.findAll();
  }

  public List<SelectItem> getTerritories() {
    List<SelectItem> options = new ArrayList<SelectItem>();
    options.add(new SelectItem(""));
    for (Territory territory : Territory.values()) {
      options.add(new SelectItem(territory.name()));
    }
    return options;
  }
}
