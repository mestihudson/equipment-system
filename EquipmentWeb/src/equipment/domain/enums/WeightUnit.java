package equipment.domain.enums;

public enum WeightUnit {
	KT,
	KG;
	
	public String getCode() {
		return this.name();
	}
}
