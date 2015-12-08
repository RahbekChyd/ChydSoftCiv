package hotciv.standard.Alpha;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Strategies.UnitStrategy;

public class AlphaUnitStrategy implements UnitStrategy {

	@Override
	public void produceUnit(Game game, Position p) {
		City c = null;
		if (game.getCityAt(p) != null)
			c = game.getCityAt(p);
			if (c.getAllProduction() >= 10 && c.getOwner() == Player.RED) {
				game.addUnit(p, c.getProduction(), c.getOwner());
				c.minusProduction(10);
			}
			if (c.getAllProduction() >= 15 && c.getOwner() == Player.BLUE){
				game.addUnit(p, c.getProduction(), c.getOwner());
				c.minusProduction(15);
			}
	}

}
