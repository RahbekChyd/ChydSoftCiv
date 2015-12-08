package hotciv.standard.Alpha;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Strategies.AttackStrategy;

public class AlphaAttackingStrategy implements AttackStrategy {

	@Override
	public void winnerOfTheBattle(Game game, Position from, Position to) {
		game.removeUnit(to);
		game.addUnit(to, game.getUnitAt(from).getTypeString(), game.getUnitAt(from).getOwner());
		game.removeUnit(from);
	}
}
