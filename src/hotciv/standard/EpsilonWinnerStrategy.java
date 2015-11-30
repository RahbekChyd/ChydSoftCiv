package hotciv.standard;

import java.util.HashMap;
import java.util.Map;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;

public class EpsilonWinnerStrategy implements WinnerStrategy {
	Map<Player, Integer> winningCount;
	
	public EpsilonWinnerStrategy() {
		winningCount = new HashMap<>();
		for (Player p : Player.values())
			winningCount.put(p, 0);
	}
	
	@Override
	public Player getWinner(Game game) {
		for (Player p : winningCount.keySet()){
			if (winningCount.get(p) == 3)
				return p;
		}
		return null;
	}
	
	public void addWinningCount(Player p, Game game) {
		int countValue = winningCount.get(p) + 1;
		winningCount.put(p, countValue);
	}

}

