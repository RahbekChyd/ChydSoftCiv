package hotciv.standard;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;

public class ZetaWinnerStrategy implements WinnerStrategy {
	WinnerStrategy ews = new EpsilonWinnerStrategy();
	WinnerStrategy bws = new BetaWinnerStrategy();
	
	@Override
	public Player getWinner(Game game) {
		WinnerStrategy currentState = bws;
		
		if (game.getRoundCount() > 20)
			currentState = ews;
		
		return currentState.getWinner(game);
	}

	@Override
	public void addWinningCount(Player p, Game game) {
		if (game.getRoundCount() > 20)
			ews.addWinningCount(p, game);
	}

}
