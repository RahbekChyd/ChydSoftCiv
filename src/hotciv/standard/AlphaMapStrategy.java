package hotciv.standard;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.MapStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class AlphaMapStrategy implements MapStrategy {
	
	public void mapLayout(Game game) {
		for (int i = 0; i<GameConstants.WORLDSIZE; i++){
			for (int j = 0; j<GameConstants.WORLDSIZE; j++){
				game.addTile(new Position(i, j), GameConstants.PLAINS);
			}
		}
		game.buildCity(new Position(1, 1), Player.RED);
		game.buildCity(new Position(4, 1), Player.BLUE);
		
		game.addTile(new Position(1, 0), GameConstants.OCEANS);
		game.addTile(new Position(0, 1), GameConstants.HILLS);
		game.addTile(new Position(2, 2), GameConstants.MOUNTAINS);

		game.addUnit(new Position(2, 0), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(3, 2), GameConstants.LEGION, Player.BLUE);
		game.addUnit(new Position(4, 3), GameConstants.SETTLER, Player.RED);
	}

	@Override
	public void generateMap(String[] tileLayout, String[] cityLayout, String[] unitLayout) {}
}
