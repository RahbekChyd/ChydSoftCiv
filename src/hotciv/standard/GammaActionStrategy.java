package hotciv.standard;

import hotciv.framework.ActionStrategy;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;

public class GammaActionStrategy implements ActionStrategy {

	public void performUnitActionAt( Position p, Game game ) {
		if (game.getUnitAt(p).getTypeString() == GameConstants.SETTLER){
			game.buildCity(p, game.getUnitAt(p).getOwner());
			game.removeUnit(p);
		}
		else if (game.getUnitAt(p).getTypeString() == GameConstants.ARCHER){
			game.getUnitAt(p).actionBonus();
		}
	}
}
