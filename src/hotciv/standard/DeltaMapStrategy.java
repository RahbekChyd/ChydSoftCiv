package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.MapStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;

public class DeltaMapStrategy implements MapStrategy {

	String tileLine;
	String cityLine;
	String unitLine;
	private Game game;

	public void mapLayout(Game game) {
		this.game = game;

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

		String[] unitLayout = new String[] {
				"raooooooraooooraoora",
				"oorsooooooooooooo",
				"oooooooooooooooo",
				"ooblooooooooooooo",
				"ooobloooooooooooo",
				"oooooooooooooooo",
				"oooooooooooooooo",
				"ooooorloooooooooo",
				"oooooooooooooooo",
				"ooooooorloooooooo",
				"oooooooooooooooo",
				"oooooorsooooooooo",
				"ooorsoooooooooooo",
				"oooobsooobsooooooo",
				"oooobsooobloooorsoo",
				"oooooooooooooooo"
		};

		generateMap(tileLayout, cityLayout, unitLayout);
	}

	@Override
	public void generateMap(String[] tileLayout, String[] cityLayout, String[] unitLayout) {
		for ( int i = 0; i < GameConstants.WORLDSIZE; i++ ) {
			tileLine = tileLayout[i];
			cityLine = cityLayout[i];
			unitLine = unitLayout[i];
			int k = 0;
			int extra = (unitLine.length() - GameConstants.WORLDSIZE);

			for ( int j = 0; j < GameConstants.WORLDSIZE; j++ ) {
				char tileChar = tileLine.charAt(j);
				char cityChar = cityLine.charAt(j);

				if ( cityChar == 'r' ) { game.buildCity(new Position(i, j), Player.RED); }
				if ( cityChar == 'b' ) { game.buildCity(new Position(i, j), Player.BLUE); } 

                if ( tileChar == 'o' ) { game.addTile(new Position(i, j), GameConstants.OCEANS); }
                if ( tileChar == 'p' ) { game.addTile(new Position(i, j), GameConstants.PLAINS); }
                if ( tileChar == 'M' ) { game.addTile(new Position(i, j), GameConstants.MOUNTAINS); }
                if ( tileChar == 'f' ) { game.addTile(new Position(i, j), GameConstants.FOREST); }
                if ( tileChar == 'h' ) { game.addTile(new Position(i, j), GameConstants.HILLS); }			 
			}

			for ( int z = 0; z < unitLine.length(); z++){    
				char unitChar = unitLine.charAt(z);

				/** 
				 * This is for red and blue ARCHERS
				 */
				if ( unitChar == 'r' ) {
					if ( unitLine.charAt(z + 1) == 'a' ) {
						if (k < extra){
							game.addUnit(new Position(i, (z-k)), GameConstants.ARCHER, Player.RED);
							k++;
						}
					}             	            		
				}
				
				if ( unitChar == 'b' ) {
					if ( unitLine.charAt(z + 1) == 'a' ) {
						if (k < extra){
							game.addUnit(new Position(i, (z-k)), GameConstants.ARCHER, Player.BLUE);
							k++;
						}
					}             	            		
				}
				
				/** 
				 * This is for red and blue LEGIONS
				 */
				if ( unitChar == 'r' ) {
					if ( unitLine.charAt(z + 1) == 'l' ) {
						if (k < extra){
							game.addUnit(new Position(i, (z-k)), GameConstants.LEGION, Player.RED);
							k++;
						}
					}             	            		
				}
				
				if ( unitChar == 'b' ) {
					if ( unitLine.charAt(z + 1) == 'l' ) {
						if (k < extra){
							game.addUnit(new Position(i, (z-k)), GameConstants.LEGION, Player.BLUE);
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
							game.addUnit(new Position(i, (z-k)), GameConstants.SETTLER, Player.RED);
							k++;
						}
					}             	            		
				}
				
				if ( unitChar == 'b' ) {
					if ( unitLine.charAt(z + 1) == 's' ) {
						if (k < extra){
							game.addUnit(new Position(i, (z-k)), GameConstants.SETTLER, Player.BLUE);
							k++;
						}
					}             	            		
				}
			}
		}
	}
}
