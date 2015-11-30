package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.MapStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

public class DeltaMapStrategy implements MapStrategy {

	String tileLine;
	String cityLine;
	String unitLine;

	@Override
	public Tile[][] tilesMap() {
		String[] tileLayout = new String[] {
				"oooppMoooooooooo",
				"oophhppppfffppoo",
				"opppppMpppoooppo",
				"oppMMMppppoopppp",
				"opppfppphhppppoo",
				"opfppfppppphhppo",
				"ooopppoooooooooo",
				"opppppoppphppMoo",
				"opppppopphpppfoo",
				"pfffppppopffpppp",
				"ppppppppoooppppp",
				"oppMMMppppoooooo",
				"ooppppppffppppoo",
				"oooopppppppppooo",
				"ooppphhppooooooo",
				"ooooopppppppppoo"
		};
		return generateTiles(tileLayout);
	}


	@Override
	public Unit[][] unitsMap() {
		String[] unitLayout = new String[] {
				"raooooooraooooraoora",
				"oorsooooooooooooo",
				"oooooooooooooooo",
				"ooblooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"ooooooobloooooooo",
				"oooooooooooooooo",
				"oooooorsooooooooo",
				"ooorsoooooooooooo",
				"ooooooooblooooooo",
				"oooooooobloooorsoo",
				"oooooooooooooooo"
		};
		return generateUnits(unitLayout);
	}

	@Override
	public City[][] cityMap() {
		String[] cityLayout = new String[] {
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooboooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooorooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo"
		};
		return generateCities(cityLayout);
	}

	public Tile[][] generateTiles(String[] tileLayout) {
		Tile[][] tiles = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for ( int i = 0; i < GameConstants.WORLDSIZE; i++ ) {
			tileLine = tileLayout[i];

			for ( int j = 0; j < GameConstants.WORLDSIZE; j++ ) {
				char tileChar = tileLine.charAt(j);

				if ( tileChar == 'o' ) { tiles[i][j] = new TileImpl(GameConstants.OCEANS); }
				if ( tileChar == 'p' ) { tiles[i][j] = new TileImpl(GameConstants.PLAINS); }
				if ( tileChar == 'M' ) { tiles[i][j] = new TileImpl(GameConstants.MOUNTAINS); }
				if ( tileChar == 'f' ) { tiles[i][j] = new TileImpl(GameConstants.FOREST); }
				if ( tileChar == 'h' ) { tiles[i][j] = new TileImpl(GameConstants.HILLS); }			 
			}
		}
		return tiles;
	}

	public City[][] generateCities(String[] cityLayout) {
		City[][] cities = new City[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for ( int i = 0; i < GameConstants.WORLDSIZE; i++ ) {
			cityLine = cityLayout[i];

			for ( int j = 0; j < GameConstants.WORLDSIZE; j++ ) {
				char cityChar = cityLine.charAt(j);

				if ( cityChar == 'r' ) { cities[i][j] = new CityImpl(Player.RED); }
				if ( cityChar == 'b' ) { cities[i][j] = new CityImpl(Player.BLUE); }	 
			}
		}
		return cities;
	}

	public Unit[][] generateUnits(String[] unitLayout) {
		Unit[][] units = new Unit[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for ( int i = 0; i < GameConstants.WORLDSIZE; i++ ) {
			unitLine = unitLayout[i];
			int k = 0;
			int extra = (unitLine.length() - GameConstants.WORLDSIZE);

			for ( int z = 0; z < unitLine.length(); z++){    
				char unitChar = unitLine.charAt(z);

				/** 
				 * This is for red and blue ARCHERS
				 */
				if ( unitChar == 'r' ) {
					if ( unitLine.charAt(z + 1) == 'a' ) {
						if (k < extra){
							units[i][z-k] = new UnitImpl(GameConstants.ARCHER, Player.RED, new Position(i, z-k));
							k++;
						}
					}             	            		
				}

				/*if ( unitChar == 'b' ) {
							if ( unitLine.charAt(z + 1) == 'a' ) {
								if (k < extra){
									game.addUnit(new Position(i, (z-k)), GameConstants.ARCHER, Player.BLUE);
									k++;
								}
							}             	            		
						}*/

				/** 
				 * This is for red and blue LEGIONS
				 */
				/*if ( unitChar == 'r' ) {
							if ( unitLine.charAt(z + 1) == 'l' ) {
								if (k < extra){
									game.addUnit(new Position(i, (z-k)), GameConstants.LEGION, Player.RED);
									k++;
								}
							}             	            		
						}*/

				if ( unitChar == 'b' ) {
					if ( unitLine.charAt(z + 1) == 'l' ) {
						if (k < extra){
							units[i][z-k] = new UnitImpl(GameConstants.LEGION, Player.BLUE, new Position(i, z-k));
							k++;
						}
					}             	            		
				}

				/** 
				 * This is for red and blue SETTLERS
				 */
				if ( unitChar == 'r' ) {
					if ( unitLine.charAt(z + 1) == 's' ) {
						if (k < extra){
							units[i][z-k] = new UnitImpl(GameConstants.SETTLER, Player.RED, new Position(i, z-k));
							k++;
						}
					}             	            		
				}
				/*
						if ( unitChar == 'b' ) {
							if ( unitLine.charAt(z + 1) == 's' ) {
								if (k < extra){
									game.addUnit(new Position(i, (z-k)), GameConstants.SETTLER, Player.BLUE);
									k++;
								}
							}             	            		
						}*/
			}
		}
		return units;
	}
}

