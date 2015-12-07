package hotciv.standard;

import hotciv.framework.ActionStrategy;
import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.Dice;
import hotciv.framework.Factory;
import hotciv.framework.MapStrategy;
import hotciv.framework.WinnerStrategy;

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
}
