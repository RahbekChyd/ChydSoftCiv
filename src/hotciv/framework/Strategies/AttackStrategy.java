package hotciv.framework.Strategies;

import hotciv.framework.Game;
import hotciv.framework.Position;

public interface AttackStrategy {
	public void winnerOfTheBattle(Game game, Position from, Position to);
}
