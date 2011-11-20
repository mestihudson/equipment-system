package equipment.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.EquipmentSupplyHierarchyDao;

@Service("facilityService")
@Scope("singleton")
@Transactional
public class FacilityServiceImpl implements FacilityService {

  @Resource(name = "equipmentSupplyHierarchyDao")
  public EquipmentSupplyHierarchyDao equipmentSupplyHierarchyDao;

  @SuppressWarnings("unchecked")
  @Override
  public List<String> findFacilityCodesStartWith(String query) {
    Criteria criteria = equipmentSupplyHierarchyDao.createCriteria();
    criteria.add(Restrictions.like(EquipmentSupplyHierarchyDao.FCIL_CDE, query + "%").ignoreCase()).setProjection(
        Property.forName(EquipmentSupplyHierarchyDao.FCIL_CDE));
    return criteria.list();
  }
}
