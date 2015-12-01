package hotciv.standard;

import hotciv.framework.Dice;

public class RollAValue implements Dice {
	private int value;
	
	public RollAValue(int v) {
		value = v;
	}
	
	@Override
	public int getValue() {
		return value;
	}

}
