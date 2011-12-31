package equipment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "EQP_REJECTION_DTL")
public class RejectionDetail {
  @Id
  @GenericGenerator(name="idGenerator", strategy="uuid")
  @GeneratedValue(generator="idGenerator")
  @Column(name = "ID")
  private String id;
  @Column(name = "EVENT_TIMESTAMP")
  private String eventTimestamp;
  @Column(name = "ERROR_CODE")
  private String rejectionCode;
  @Column(name = "RULE")
  private String ruleName;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
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
