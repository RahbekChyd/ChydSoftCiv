package hotciv.standard.Factories;

import hotciv.framework.Dice;
import hotciv.framework.Factory;
import hotciv.framework.Strategies.ActionStrategy;
import hotciv.framework.Strategies.AgeStrategy;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.framework.Strategies.UnitStrategy;
import hotciv.framework.Strategies.WinnerStrategy;
import hotciv.standard.Alpha.AlphaUnitStrategy;
import hotciv.standard.Beta.BetaAgeStrategy;
import hotciv.standard.Delta.DeltaMapStrategy;
import hotciv.standard.Epsilon.EpsilonAttackingStrategy;
import hotciv.standard.Epsilon.EpsilonWinnerStrategy;
import hotciv.standard.Gamma.GammaActionStrategy;

public class SemiFactory implements Factory {
	Dice dice;
	EpsilonAttackingStrategy attStrat;
	
	public SemiFactory(Dice dice) {
		this.dice = dice;
		attStrat = new EpsilonAttackingStrategy(dice);
	}

	@Override
	public AgeStrategy ageStrategy() {
		return new BetaAgeStrategy();
	}

	@Override
	public WinnerStrategy winnerStrategy() {
		return new EpsilonWinnerStrategy();
	}

	@Override
	public ActionStrategy actionStrategy() {
		return new GammaActionStrategy();
	}

	@Override
	public MapStrategy mapStrategy() {
		return new DeltaMapStrategy();
	}

	@Override
	public AttackStrategy attStrategy() {
		return attStrat;
	}
	
	@Override
	public UnitStrategy unitStrategy() {
		return new AlphaUnitStrategy();
	}
}
