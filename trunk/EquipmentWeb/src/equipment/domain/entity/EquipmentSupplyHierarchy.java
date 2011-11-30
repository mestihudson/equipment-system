package equipment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import equipment.domain.enums.Territory;

@Entity(name="EQP_SUPPLY_HIERARCHY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EquipmentSupplyHierarchy {

  @Id
  @Column(name="FCIL_CDE")
  private String facilityCode;
  
  @Column(name="OFCE_CDE")
  private String officeCode;

  @Column(name="REG_CDE")
  private String regionCode;
  
  @Enumerated(value = EnumType.STRING)
  @Column(name="TERRITORY")
  private Territory territory;

  public String getFacilityCode() {
    return facilityCode;
  }

  public void setFacilityCode(String facilityCode) {
    this.facilityCode = facilityCode;
  }

  public String getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  public Territory getTerritory() {
    return territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }
  
  
}
