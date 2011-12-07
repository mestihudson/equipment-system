package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.EquipmentSupplyHierarchyDao;
import equipment.domain.entity.EquipmentSupplyHierarchy;

@Component("hierarchyBean")
@Scope("request")
public class HierarchyBean implements Serializable{
  private static final long serialVersionUID = -5650490585039961293L;
  @Resource(name="equipmentSupplyHierarchyDao")
  private EquipmentSupplyHierarchyDao equipmentSupplyHierarchyDao;

  public List<EquipmentSupplyHierarchy> getSupplyHierarchies() {
    return equipmentSupplyHierarchyDao.findAll();
  }
  
  public SelectItem[] getTerritories() {
    SelectItem[] options = new SelectItem[4];
    options[0] = new SelectItem("");
    options[1] = new SelectItem("APT");
    options[2] = new SelectItem("EUT");
    options[3] = new SelectItem("NAT");
    return options;
  }
}
