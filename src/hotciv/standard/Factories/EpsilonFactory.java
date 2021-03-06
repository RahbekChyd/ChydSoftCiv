package hotciv.standard.Factories;

import hotciv.framework.Dice;
import hotciv.framework.Factory;
import hotciv.framework.Strategies.ActionStrategy;
import hotciv.framework.Strategies.AgeStrategy;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.framework.Strategies.UnitStrategy;
import hotciv.framework.Strategies.WinnerStrategy;
import hotciv.standard.Alpha.AlphaActionStrategy;
import hotciv.standard.Alpha.AlphaAgeStrategy;
import hotciv.standard.Alpha.AlphaMapStrategy;
import hotciv.standard.Alpha.AlphaUnitStrategy;
import hotciv.standard.Epsilon.EpsilonAttackingStrategy;
import hotciv.standard.Epsilon.EpsilonWinnerStrategy;

public class EpsilonFactory implements Factory {
	Dice dice;
	EpsilonAttackingStrategy attStrat;
	
	public EpsilonFactory(Dice dice) {
		this.dice = dice;
		attStrat = new EpsilonAttackingStrategy(dice);
	}
	
	@Override
	public AgeStrategy ageStrategy() {
		return new AlphaAgeStrategy();
	}

	@Override
	public WinnerStrategy winnerStrategy() {
		return new EpsilonWinnerStrategy();
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
		return attStrat;
	}
	
	@Override
	public UnitStrategy unitStrategy() {
		return new AlphaUnitStrategy();
	}

}
