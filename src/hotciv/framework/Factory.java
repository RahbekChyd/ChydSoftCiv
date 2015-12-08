package hotciv.framework;

import hotciv.framework.Strategies.ActionStrategy;
import hotciv.framework.Strategies.AgeStrategy;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.framework.Strategies.UnitStrategy;
import hotciv.framework.Strategies.WinnerStrategy;

public interface Factory {
	AgeStrategy ageStrategy();
	WinnerStrategy winnerStrategy();
	ActionStrategy actionStrategy();
	MapStrategy mapStrategy();
	AttackStrategy attStrategy();
	UnitStrategy unitStrategy();
}
