package hotciv.standard;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.ThetaConstants;
import hotciv.standard.Factories.ThetaFactory;

public class TestThetaCiv {
	private Game game;

	@Before
	public void setUp() {
		game = new GameImpl(new ThetaFactory());
	}
	
	@Test
	public void redCityProduceArcherWhenEnoughProduction() {
		game.changeProductionInCityAt(new Position(1, 1), ThetaConstants.Chariot);
		endRoundAfterTurn();
		endRoundAfterTurn();
		endRoundAfterTurn();
		endRoundAfterTurn();
		game.produceUnit(new Position(1, 1));
		assertThat("Red city produce archer when production above 10", game.getUnitAt(new Position(1, 1)).getTypeString(), is(ThetaConstants.Chariot));
	}
	
	@Test
	public void chariotActionActivated() {
		game.addUnit(new Position(5, 5), ThetaConstants.Chariot, Player.RED);
		game.performUnitActionAt(new Position(5, 5));
		assertThat("Chariot perform action doubles defensive strength", game.getUnitAt(new Position(5, 5)).getDefensiveStrength(), is(2));
	}
	
	@Test
	public void chariotActionDeactivated() {
		game.addUnit(new Position(5, 5), ThetaConstants.Chariot, Player.RED);
		game.performUnitActionAt(new Position(5, 5));
		assertThat("Chariot perform action doubles defensive strength", game.getUnitAt(new Position(5, 5)).getDefensiveStrength(), is(2));
		game.performUnitActionAt(new Position(5, 5));
		assertThat("Chariot perfom action again resets defensive strength", game.getUnitAt(new Position(5, 5)).getDefensiveStrength(), is(1));
	}
	
	public void endRoundAfterTurn() {
		game.endOfTurn();
		game.endOfTurn();
	}
}
