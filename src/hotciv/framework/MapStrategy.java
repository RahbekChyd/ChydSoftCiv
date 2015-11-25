package hotciv.framework;

public interface MapStrategy {
	public void mapLayout(Game game);
	public void generateMap(String [] tileLayout, String [] cityLayout, String [] unitLayout);
}
