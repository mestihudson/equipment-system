package equipment.domain.enums;

public enum DocumentType {
	BM("B/L"),
	BN("Booking"),
	OE("Oceanic Empty"),
	EP("Empty Plan");
	
	private String description;
	
	private DocumentType(String description) {
		this.description = description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
