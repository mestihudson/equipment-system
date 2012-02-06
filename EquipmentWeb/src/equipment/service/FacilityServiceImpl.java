package equipment.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.SupplyHierarchyDao;
import equipment.domain.entity.SupplyHierarchy;

@Service("facilityService")
@Scope("singleton")
@Transactional
public class FacilityServiceImpl implements FacilityService {

  @Autowired
  public SupplyHierarchyDao supplyHierarchyDao;

  @SuppressWarnings("unchecked")
  @Override
  public List<String> findFacilityCodesStartWith(String query) {
    Criteria criteria = supplyHierarchyDao.createCriteria();
    criteria.add(Restrictions.like(SupplyHierarchyDao.FACILITY, query.toUpperCase() + "%")).setProjection(
        Property.forName(SupplyHierarchyDao.FACILITY));
    return criteria.list();
  }

  @Override
  public SupplyHierarchy getSupplyHierarchy(String facilityCode) {
    return supplyHierarchyDao.findById(facilityCode);
  }
}
