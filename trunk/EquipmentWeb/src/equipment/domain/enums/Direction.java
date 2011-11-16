package equipment.domain.enums;

public enum Direction {
	E("East"),
	W("West"),
	S("South"),
	N("North");
	
	private String label;
	
	private Direction(String label) {
		this.setLabel(label);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
