package enums;

public enum CardNameEnum {

	COPPER("copper"),
	SILVER("silver"),
	GOLD("gold"),
	ESTATE("estate"),
	DUCHY("duchy"),
	PROVINCE("province"),
	CURSE("curse"),
	SMITHY("smithy"),
	CHAPEL("chapel"),
	CELLAR("cellar"),
	VILLAGE("village"),
	WORKSHOP("workshop"),
	REMODEL("remodel"),
	MILITIA("militia"),
	GARDENS("gardens"),
	MARKET("market"),
	WITCH("witch"),

	;

	private String string = null;

	private CardNameEnum(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

}
