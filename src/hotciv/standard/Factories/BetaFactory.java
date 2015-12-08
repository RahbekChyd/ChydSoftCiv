package hotciv.standard.Factories;

import hotciv.framework.Factory;
import hotciv.framework.Strategies.ActionStrategy;
import hotciv.framework.Strategies.AgeStrategy;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.framework.Strategies.UnitStrategy;
import hotciv.framework.Strategies.WinnerStrategy;
import hotciv.standard.Alpha.AlphaActionStrategy;
import hotciv.standard.Alpha.AlphaAttackingStrategy;
import hotciv.standard.Alpha.AlphaMapStrategy;
import hotciv.standard.Alpha.AlphaUnitStrategy;
import hotciv.standard.Beta.BetaAgeStrategy;
import hotciv.standard.Beta.BetaWinnerStrategy;

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

	@Override
	public UnitStrategy unitStrategy() {
		return new AlphaUnitStrategy();
	}

}
