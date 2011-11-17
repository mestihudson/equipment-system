package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.EquipmentEventDao;
import equipment.domain.EquipmentEvent;

@Component("movementEnquiryBean")
@Scope("request")
public class MovementEnquiryBean implements Serializable{
	private static final long serialVersionUID = -1522497061055049165L;
	
	@Resource(name="equipmentEventDao")
	private EquipmentEventDao equipmentEventDao;
	
	private List<EquipmentEvent> equipmentEvents;

	public List<EquipmentEvent> getEquipmentEvents() {
		if(equipmentEvents == null) {
			equipmentEvents = equipmentEventDao.findAll();
		}
		return equipmentEvents;
	}
}
