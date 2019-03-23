package enums;

public enum PlayerEnum {

	HUMAN("Human"), AI("AI");

	private String string = null;

	private PlayerEnum(String string) {
		this.string = string;
	}

	public String string() {
		return this.string;
	}

}
