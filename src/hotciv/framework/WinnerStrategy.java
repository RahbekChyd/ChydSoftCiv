package hotciv.framework;

public interface WinnerStrategy {
	public Player getWinner(Game game);
	public void addWinningCount(Player p, Game game);
}
