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
  @Column(name="FACILITY")
  private String facility;
  
  @Column(name="OFFICE")
  private String office;

  @Column(name="REG_CDE")
  private String regionCode;
  
  @Column(name="REGION")
  private String region;
  
  @Enumerated(value = EnumType.STRING)
  @Column(name="TERRITORY")
  private Territory territory;

  public String getFacility() {
    return facility;
  }

  public void setFacility(String facility) {
    this.facility = facility;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Territory getTerritory() {
    return territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }

  
}
