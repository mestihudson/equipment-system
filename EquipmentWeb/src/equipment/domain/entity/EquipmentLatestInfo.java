package equipment.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "EQP_LATEST_INFO")
public class EquipmentLatestInfo implements Serializable {
  private static final long serialVersionUID = -8402222674061767273L;

  @Id
  @Column(name = "EQMT_NUM")
  private String equipmentNumber;

  public String getEquipmentNumber() {
    return equipmentNumber;
  }

  public void setEquipmentNumber(String equipmentNumber) {
    this.equipmentNumber = equipmentNumber;
  }
}
