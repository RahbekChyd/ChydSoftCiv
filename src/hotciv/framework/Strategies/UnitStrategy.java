package hotciv.framework.Strategies;

import hotciv.framework.Game;
import hotciv.framework.Position;

public interface UnitStrategy {
	public void produceUnit(Game game, Position p);
}
