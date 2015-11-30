package hotciv.framework;

public interface MapStrategy {
	public Tile[][] tilesMap();
	public Unit[][] unitsMap();
	public City[][] cityMap();
}
