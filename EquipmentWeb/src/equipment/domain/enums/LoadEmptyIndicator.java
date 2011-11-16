package equipment.domain.enums;

public enum LoadEmptyIndicator {
	E("Empty"), F("Ladden");

	private String description;

	private LoadEmptyIndicator(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
