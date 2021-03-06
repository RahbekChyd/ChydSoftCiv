package hotciv.standard.Alpha;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Strategies.WinnerStrategy;

public class AlphaWinnerStrategy implements WinnerStrategy {

	@Override
	public Player getWinner(Game game) {
		if(game.getAge() == -3000)
			return Player.RED;
		return null;
	}

	@Override
	public void addWinningCount(Player p, Game game) {
		//Only for Epsilon, best solution for now!
	}
}
