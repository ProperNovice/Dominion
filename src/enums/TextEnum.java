package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	ACTION_PHASE("Action phase", TextTypeEnum.INDICATOR),
	BUY_PHASE("Buy phase", TextTypeEnum.INDICATOR),
	CLEAN_UP_PHASE("Clean-up phase", TextTypeEnum.INDICATOR),
	PROCEED_TO_NEXT_PHASE("Proceed to next phase", TextTypeEnum.OPTION),
	END_TURN("End turn", TextTypeEnum.OPTION),
	PLAY_HAND_TREASURES("Play hand treasures", TextTypeEnum.OPTION),
	

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
