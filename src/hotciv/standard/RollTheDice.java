package hotciv.standard;

import hotciv.framework.Dice;

public class RollTheDice implements Dice {

	@Override
	public int getValue() {
		return (int) ((Math.random()*6)+1);
	}
}