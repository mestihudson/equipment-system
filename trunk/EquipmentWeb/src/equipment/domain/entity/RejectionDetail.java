package equipment.domain.entity;

public class RejectionDetail {
  private String eventTimestamp;
  private String rejectionCode;
  private String ruleName;
  public String getEventTimestamp() {
    return eventTimestamp;
  }
  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }
  public String getRejectionCode() {
    return rejectionCode;
  }
  public void setRejectionCode(String rejectionCode) {
    this.rejectionCode = rejectionCode;
  }
  public String getRuleName() {
    return ruleName;
  }
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }
}
