package equipment.web.jsf.mbean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import equipment.domain.entity.EquipmentEvent;

public class EquipmentEventDataModel extends ListDataModel<EquipmentEvent> implements SelectableDataModel<EquipmentEvent> {

  public EquipmentEventDataModel() {
    super();
  }

  public EquipmentEventDataModel(List<EquipmentEvent> data) {
    super(data);
  }

  @SuppressWarnings("unchecked")
  @Override
  public EquipmentEvent getRowData(String eventTimestamp) {
    List<EquipmentEvent> equipmentEvents = (List<EquipmentEvent>)getWrappedData();
    for(EquipmentEvent equipmentEvent : equipmentEvents) {
      if(equipmentEvent.getEventTimestamp().equals(eventTimestamp)) {
        return equipmentEvent;
      }
    }
    return null;
  }

  @Override
  public Object getRowKey(EquipmentEvent equipmentEvent) {
    return equipmentEvent.getEventTimestamp();
  }

}
