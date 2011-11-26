package equipment.web.jsf.mbean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import equipment.domain.EquipmentEvent;

public class EquipmentEventDataModel extends ListDataModel<EquipmentEvent> implements SelectableDataModel<EquipmentEvent> {

  public EquipmentEventDataModel() {
    super();
  }

  public EquipmentEventDataModel(List<EquipmentEvent> data) {
    super(data);
  }

  @Override
  public EquipmentEvent getRowData(String eventTimestamp) {
    //TODO
    return null;
  }

  @Override
  public Object getRowKey(EquipmentEvent equipmentEvent) {
    return equipmentEvent.getEventTimestamp();
  }

}
