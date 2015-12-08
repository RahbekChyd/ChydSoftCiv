package hotciv.framework.Strategies;

import hotciv.framework.Game;
import hotciv.framework.Position;

public interface ActionStrategy {
	public void performUnitActionAt( Position p, Game game );
}
