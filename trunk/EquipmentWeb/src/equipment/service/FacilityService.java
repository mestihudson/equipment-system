package equipment.service;

import java.util.List;

import equipment.domain.entity.SupplyHierarchy;


public interface FacilityService {
	List<String> findFacilityCodesStartWith(String query);
	SupplyHierarchy getSupplyHierarchy(String facilityCode);
}
