package hotciv.standard.Theta;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Strategies.UnitStrategy;

public class ThetaUnitStrategy implements UnitStrategy {

	@Override
	public void produceUnit(Game game, Position p) {
		City c = null;
		if (game.getCityAt(p) != null)
			c = game.getCityAt(p);
			if (c.getAllProduction() >= 10) {
				game.addUnit(p, c.getProduction(), c.getOwner());
				c.minusProduction(10);
			}
			if (c.getAllProduction() >= 15){
				game.addUnit(p, c.getProduction(), c.getOwner());
				c.minusProduction(15);
			}
			if (c.getAllProduction() >= 20){
				game.addUnit(p, c.getProduction(), c.getOwner());
				c.minusProduction(20);
			}
	}

}
