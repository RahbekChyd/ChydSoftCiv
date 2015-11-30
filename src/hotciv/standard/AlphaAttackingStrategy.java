package hotciv.standard;

import hotciv.framework.AttackStrategy;
import hotciv.framework.Game;
import hotciv.framework.Position;

public class AlphaAttackingStrategy implements AttackStrategy {

	@Override
	public void winnerOfTheBattle(Game game, Position from, Position to) {
		game.removeUnit(to);
		game.addUnit(to, game.getUnitAt(from).getTypeString(), game.getUnitAt(from).getOwner());
		game.removeUnit(from);
	}
}
