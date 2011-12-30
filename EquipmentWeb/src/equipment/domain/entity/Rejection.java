package equipment.domain.entity;

import java.util.Collection;

public class Rejection {
  private String eventTimestamp;

  private Collection<RejectionDetail> rejectionDetails;

  public Collection<RejectionDetail> getRejectionDetails() {
    return rejectionDetails;
  }

  public void setRejectionDetails(Collection<RejectionDetail> rejectionDetails) {
    this.rejectionDetails = rejectionDetails;
  }

  public String getEventTimestamp() {
    return eventTimestamp;
  }

  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }
  
}
