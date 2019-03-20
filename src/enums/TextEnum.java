package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	ACTION_PHASE("Action phase", TextTypeEnum.INDICATOR),
	RESOLVE_ACTION("Resolve action", TextTypeEnum.OPTION),
	BUY_PHASE("Buy phase", TextTypeEnum.INDICATOR),
	CLEAN_UP_PHASE("Clean-up phase", TextTypeEnum.INDICATOR),
	CLEAN_UP("Clean-up", TextTypeEnum.OPTION),
	PROCEED_TO_NEXT_PHASE("Proceed to next phase", TextTypeEnum.OPTION),
	END_TURN("End turn", TextTypeEnum.OPTION),
	NEW_TURN("New turn", TextTypeEnum.OPTION),
	PLAY_HAND_TREASURES("Play hand treasures", TextTypeEnum.OPTION),
	BUY_CARD("Buy card", TextTypeEnum.OPTION),
	CHOOSE_CARDS_TO_DISCARD("Choose cards to discard", TextTypeEnum.INDICATOR),
	CHOOSE_CARDS_TO_TRASH("Choose cards to trash", TextTypeEnum.INDICATOR),
	CHOOSE_A_CARD_COSTING_UP_TO_FOUR("Choose a card costing up to four", TextTypeEnum.INDICATOR),
	CHOOSE_A_CARD_TO_TRASH("Choose a card to trash", TextTypeEnum.INDICATOR),
	CHOOSE_A_CARD_COSTING_UP_TO_TWO_MORE("Choose a card costing up to two more", TextTypeEnum.INDICATOR),
	

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
