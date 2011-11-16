package equipment.domain.enums;

public enum EquipmentCondition {
	UNCHECKED("Unchecked"),
	GOOD("Good"),
	DAMAGED("Damaged");
	
	private String description;
	
	private EquipmentCondition(String description) {
		this.setDescription(description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
