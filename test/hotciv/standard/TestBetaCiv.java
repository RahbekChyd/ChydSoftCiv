package hotciv.standard;

import org.junit.Test;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;


public class TestBetaCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new BetaWinnerStrategy());
	}
	
	@Test
	public void ifRedAttackBlueCityRedConquerIt() {
		game.moveUnit(new Position(2, 0), new Position(4, 1));
		assertThat("If red unit attacks blue city, the city owner will be red", game.getCityAt(new Position(4, 1)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void redWinsIfRedHaveBothCities() {
		game.moveUnit(new Position(2, 0), new Position(4, 1));
		assertThat("Red wins if red have conquered both cities", game.getWinner(), is(Player.RED));
	}
	
		@Test
	public void blueWinsIfBlueHaveBothCities() {
		game.endOfTurn();
		game.moveUnit(new Position(3, 2), new Position(1, 1));
		assertThat("Blue wins if blue have conquered both cities", game.getWinner(), is(Player.BLUE));
	}
	
	
	public void endRoundAfterTurn() {
		game.endOfTurn();
		game.endOfTurn();
	}

	public void end5Rounds() {
		for (int i = 0; i < 5; i++)
			endRoundAfterTurn();
	}
}
