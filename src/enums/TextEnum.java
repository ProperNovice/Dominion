package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	ACTION_PHASE("Action phase", TextTypeEnum.INDICATOR),
	PROCEED_TO_BUY_PHASE("Proceed to buy phase", TextTypeEnum.OPTION),
	

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
