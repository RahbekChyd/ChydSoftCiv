package hotciv.standard.Alpha;

import hotciv.framework.Game;
import hotciv.framework.Strategies.AgeStrategy;

public class AlphaAgeStrategy implements AgeStrategy {

	@Override
	public int ageCalculator(Game game) {
		return 100;
	}

}
