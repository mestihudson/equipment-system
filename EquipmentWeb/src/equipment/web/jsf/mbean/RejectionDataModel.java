package equipment.web.jsf.mbean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import equipment.domain.entity.Rejection;

public class RejectionDataModel extends ListDataModel<Rejection> implements SelectableDataModel<Rejection> {

  public RejectionDataModel() {
    super();
  }

  public RejectionDataModel(List<Rejection> data) {
    super(data);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Rejection getRowData(String eventTimestamp) {
    List<Rejection> rejections = (List<Rejection>)getWrappedData();
    for(Rejection rejection : rejections) {
      if(rejection.getEventTimestamp().equals(eventTimestamp)) {
        return rejection;
      }
    }
    return null;
  }

  @Override
  public Object getRowKey(Rejection rejection) {
    return rejection.getEventTimestamp();
  }

}
