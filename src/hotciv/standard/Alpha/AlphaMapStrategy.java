package hotciv.standard.Alpha;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

public class AlphaMapStrategy implements MapStrategy {

	@Override
	public Tile[][] tilesMap() {
		Tile[][] tiles = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for (int i = 0; i<GameConstants.WORLDSIZE; i++){
			for (int j = 0; j<GameConstants.WORLDSIZE; j++){
				tiles[i][j] = new TileImpl(GameConstants.PLAINS);
			}
		}
	
		tiles[1][0] = new TileImpl(GameConstants.OCEANS);
		tiles[0][1] = new TileImpl(GameConstants.HILLS);
		tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		
		return tiles;
	}

	@Override
	public Unit[][] unitsMap() {
		Unit[][] units = new Unit[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED, new Position(2, 0));
		units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE, new Position(3, 2));
		units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED, new Position(4, 3));
		
		return units;
	}

	@Override
	public City[][] cityMap() {
		City[][] cities = new City[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		cities[1][1] = new CityImpl(Player.RED);
		cities[4][1] = new CityImpl(Player.BLUE);
		
		return cities;
	}
}
