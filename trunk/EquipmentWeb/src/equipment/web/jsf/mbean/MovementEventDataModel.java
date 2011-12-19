package equipment.web.jsf.mbean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import equipment.domain.entity.MovementEvent;

public class MovementEventDataModel extends ListDataModel<MovementEvent> implements SelectableDataModel<MovementEvent> {

  public MovementEventDataModel() {
    super();
  }

  public MovementEventDataModel(List<MovementEvent> data) {
    super(data);
  }

  @SuppressWarnings("unchecked")
  @Override
  public MovementEvent getRowData(String eventTimestamp) {
    List<MovementEvent> equipmentEvents = (List<MovementEvent>)getWrappedData();
    for(MovementEvent equipmentEvent : equipmentEvents) {
      if(equipmentEvent.getEventTimestamp().equals(eventTimestamp)) {
        return equipmentEvent;
      }
    }
    return null;
  }

  @Override
  public Object getRowKey(MovementEvent equipmentEvent) {
    return equipmentEvent.getEventTimestamp();
  }

}
