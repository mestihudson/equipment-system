package equipment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACILITY_SUPP")
public class Facility {
	public static final String FCIL_CDE = "code";
	public static final String REG_CDE = "regionCode";
	
	@Id
	@Column(name = "FCIL_CDE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REG_CDE")
	private String regionCode;

	@Column(name = "REC_UPD_DT")
	private Date recordUpdateDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public Date getRecordUpdateDate() {
		return recordUpdateDate;
	}

	public void setRecordUpdateDate(Date recordUpdateDate) {
		this.recordUpdateDate = recordUpdateDate;
	}

}
