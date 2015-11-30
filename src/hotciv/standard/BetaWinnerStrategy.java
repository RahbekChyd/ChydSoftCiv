package hotciv.standard;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinnerStrategy;

public class BetaWinnerStrategy implements WinnerStrategy {

	@Override
	public Player getWinner(Game game) {
		if(game.getCityAt(new Position(1, 1)).getOwner() == Player.RED){
			if(game.getCityAt(new Position(4, 1)).getOwner() == Player.RED)
				return Player.RED;
		}
		if (game.getCityAt(new Position(4, 1)).getOwner() == Player.BLUE){
			if (game.getCityAt(new Position(1, 1)).getOwner() == Player.BLUE)
				return Player.BLUE;
		}
		return null;			
	}

	@Override
	public void addWinningCount(Player p, Game game) {
		//Only for Epsilon, best solution for now!
	}

}
