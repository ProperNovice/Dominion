package enums;

public enum CardName {

	;

	private String string = null;

	private CardName(String string) {
		this.string = string;
	}

	public String string() {
		return this.string;
	}

}
