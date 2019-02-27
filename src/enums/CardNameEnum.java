package enums;

public enum CardNameEnum {

	COPPER("copper"),
	SILVER("silver"),
	GOLD("gold"),
	ESTATE("estate"),
	DUCHY("duchy"),
	PROVINCE("province"),
	CURSE("curse"),

	;

	private String string = null;

	private CardNameEnum(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

}
