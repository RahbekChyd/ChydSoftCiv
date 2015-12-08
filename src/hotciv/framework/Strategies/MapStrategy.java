package hotciv.framework.Strategies;

import hotciv.framework.City;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

public interface MapStrategy {
	public Tile[][] tilesMap();
	public Unit[][] unitsMap();
	public City[][] cityMap();
}
