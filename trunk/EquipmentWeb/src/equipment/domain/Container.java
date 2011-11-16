package equipment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTAINER")
public class Container {
	@Id
	@Column(name="EQMT_NUM")
	private String equipmentNumber;
	
	@Column(name="ISO_CDE")
	private String isoCode;
	
	@Column(name="GROUP_CDE")
	private String groupCode;
	
	@Column(name="CHK_DIGIT")
	private Character checkDigit;
	
	@Column(name="STATE")
	private Boolean state;
	
	@Column(name="CREATE_DT")
	private Date createDateTime;
	
	@Column(name="UPDATE_DT")
	private Date updateDateTime;

	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

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

	public Character getCheckDigit() {
    return checkDigit;
  }

  public void setCheckDigit(Character checkDigit) {
    this.checkDigit = checkDigit;
  }

  public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
}
