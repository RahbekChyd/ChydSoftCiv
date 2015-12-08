package hotciv.standard.Theta;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.ThetaConstants;
import hotciv.framework.Strategies.ActionStrategy;

public class ThetaActionStrategy implements ActionStrategy {

	@Override
	public void performUnitActionAt(Position p, Game game) {
		if (game.getUnitAt(p).getTypeString() == GameConstants.SETTLER){
			game.buildCity(p, game.getUnitAt(p).getOwner());
			game.removeUnit(p);
		}
		else if (game.getUnitAt(p).getTypeString() == GameConstants.ARCHER){
			game.getUnitAt(p).actionBonus();
		}
		else if (game.getUnitAt(p).getTypeString() == ThetaConstants.Chariot) {
			game.getUnitAt(p).actionBonus();
		}
	}

}
