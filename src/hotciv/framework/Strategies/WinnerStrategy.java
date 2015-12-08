package hotciv.framework.Strategies;

import hotciv.framework.Game;
import hotciv.framework.Player;

public interface WinnerStrategy {
	public Player getWinner(Game game);
	public void addWinningCount(Player p, Game game);
}
