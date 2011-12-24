package equipment.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CNTR_ISO_TYPE")
public class ContainerIsoType implements Serializable{
  private static final long serialVersionUID = -7019881277304361575L;

  @Id
  @Column(name="ISO_CDE")
  private String isoCode;
  
  @Column(name="GROUP_CDE")
  private String groupCode;
  
  @Column(name="DESCRIPTION")
  private String description;

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public String getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
}
