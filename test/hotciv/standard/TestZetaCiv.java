package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.Factories.ZetaFactory;

public class TestZetaCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new ZetaFactory());
	}

	@Test
	public void until20RoundsRedWinsIfRedHaveBothCities() {
		game.moveUnit(new Position(2, 0), new Position(4, 1));
		assertThat("Red wins if red have conquered both cities", game.getWinner(), is(Player.RED));
	}
	
	@Test
	public void after20RoundsRedWinsWhenRedWon3Battles() {
		game.addUnit(new Position(0, 7), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 12), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 15), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(3, 4), GameConstants.LEGION, Player.BLUE);
		game.addUnit(new Position(3, 6), GameConstants.LEGION, Player.BLUE);
		end20Rounds();
		endRoundAfterTurn();
		game.moveUnit(new Position(0, 7), new Position(3, 2));
		game.moveUnit(new Position(0, 12), new Position(3, 4));
		assertThat("When red has won 2 battles, red hasnt won", game.getWinner(), is(nullValue()));
		game.moveUnit(new Position(0, 15), new Position(3, 6));
		assertThat("When red has won 3 battles, red win", game.getWinner(), is(Player.RED));
	}
	
	public void endRoundAfterTurn() {
		game.endOfTurn();
		game.endOfTurn();
	}

	public void end20Rounds() {
		for (int i = 0; i < 20; i++)
			endRoundAfterTurn();
	}
}
