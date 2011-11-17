package equipment.service;

import java.util.List;


public interface FacilityService {
	List<String> findFacilityCodesStartWith(String query);
}
