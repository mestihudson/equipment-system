package equipment.service;

import java.util.List;

import equipment.domain.Facility;


public interface FacilityService {
	List<String> findAll();
	List<String> findFacilityCodesStartWith(String query);
	void save(Facility facility);
}
