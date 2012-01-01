package equipment.web.jsf.mbean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.RejectionDao;
import equipment.domain.entity.Rejection;
import equipment.domain.enums.EventType;
import equipment.utils.StringUtil;

@Component("rejectionBean")
@Scope("view")
public class RejectionBean extends AbstractManagedBean {
  private static final long serialVersionUID = -7487977573754688371L;

  @Autowired
  private RejectionDao rejectionDao;

  private String containerNumber;
  private EventType eventType;
  private Rejection[] selectedRejections;
  private RejectionDataModel mediumEventsModel;
  private Rejection rejectionInDialog;

  public RejectionDataModel getMediumEventsModel() {
    return mediumEventsModel;
  }

  public void search() {
    Map<String, Object> propertyNameValues = new HashMap<String, Object>();
    if (StringUtil.isNotNullAndNotEmptyWithTrim(containerNumber)) {
      propertyNameValues.put("containerNumber", containerNumber);
    }
    if (eventType != null) {
      propertyNameValues.put("eventType", eventType);
    }
    List<Rejection> data = rejectionDao.findBy(propertyNameValues);
    mediumEventsModel = new RejectionDataModel(data);
  }

  public void delete() {
    if (selectedRejections.length == 0) {
      addWarnMessage("Please select a rejection");
    } else {
      List<?> rejections = (List<?>)mediumEventsModel.getWrappedData();
      for (Rejection rejection : selectedRejections) {
        rejectionDao.delete(rejection);
        rejections.remove(rejection);
      }
    }
  }

  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK);
  }

  public void setMediumEventsModel(RejectionDataModel mediumEventsModel) {
    this.mediumEventsModel = mediumEventsModel;
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public Rejection[] getSelectedRejections() {
    return selectedRejections;
  }

  public void setSelectedRejections(Rejection[] selectedRejections) {
    this.selectedRejections = selectedRejections;
  }

  public Rejection getRejectionInDialog() {
    return rejectionInDialog;
  }

  public void setRejectionInDialog(Rejection rejectionInDialog) {
    this.rejectionInDialog = rejectionInDialog;
  }

}
