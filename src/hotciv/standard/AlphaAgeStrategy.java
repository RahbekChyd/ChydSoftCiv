package hotciv.standard;

import hotciv.framework.AgeStrategy;
import hotciv.framework.Game;

public class AlphaAgeStrategy implements AgeStrategy {

	@Override
	public int ageCalculator(Game game) {
		return 100;
	}

}
