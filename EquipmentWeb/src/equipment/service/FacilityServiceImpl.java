package equipment.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.SupplyHierarchyDao;

@Service("facilityService")
@Scope("singleton")
@Transactional
public class FacilityServiceImpl implements FacilityService {

  @Resource(name = "equipmentSupplyHierarchyDao")
  public SupplyHierarchyDao equipmentSupplyHierarchyDao;

  @SuppressWarnings("unchecked")
  @Override
  public List<String> findFacilityCodesStartWith(String query) {
    Criteria criteria = equipmentSupplyHierarchyDao.createCriteria();
    criteria.add(Restrictions.like(SupplyHierarchyDao.FACILITY, query.toUpperCase() + "%")).setProjection(
        Property.forName(SupplyHierarchyDao.FACILITY));
    return criteria.list();
  }
}
