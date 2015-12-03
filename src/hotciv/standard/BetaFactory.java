package hotciv.standard;

import hotciv.framework.ActionStrategy;
import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.Factory;
import hotciv.framework.MapStrategy;
import hotciv.framework.WinnerStrategy;

public class BetaFactory implements Factory {

	@Override
	public AgeStrategy ageStrategy() {
		return new BetaAgeStrategy();
	}

	@Override
	public WinnerStrategy winnerStrategy() {
		return new BetaWinnerStrategy();
	}

	@Override
	public ActionStrategy actionStrategy() {
		return new AlphaActionStrategy();
	}

	@Override
	public MapStrategy mapStrategy() {
		return new AlphaMapStrategy();
	}

	@Override
	public AttackStrategy attStrategy() {
		return new AlphaAttackingStrategy();
	}

}
