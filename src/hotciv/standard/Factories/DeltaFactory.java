package hotciv.standard.Factories;

import hotciv.framework.Factory;
import hotciv.framework.Strategies.ActionStrategy;
import hotciv.framework.Strategies.AgeStrategy;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.framework.Strategies.UnitStrategy;
import hotciv.framework.Strategies.WinnerStrategy;
import hotciv.standard.Alpha.AlphaActionStrategy;
import hotciv.standard.Alpha.AlphaAgeStrategy;
import hotciv.standard.Alpha.AlphaAttackingStrategy;
import hotciv.standard.Alpha.AlphaUnitStrategy;
import hotciv.standard.Alpha.AlphaWinnerStrategy;
import hotciv.standard.Delta.DeltaMapStrategy;

public class DeltaFactory implements Factory {

	@Override
	public AgeStrategy ageStrategy() {
		return new AlphaAgeStrategy();
	}

	@Override
	public WinnerStrategy winnerStrategy() {
		return new AlphaWinnerStrategy();
	}

	@Override
	public ActionStrategy actionStrategy() {
		return new AlphaActionStrategy();
	}

	@Override
	public MapStrategy mapStrategy() {
		return new DeltaMapStrategy();
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
