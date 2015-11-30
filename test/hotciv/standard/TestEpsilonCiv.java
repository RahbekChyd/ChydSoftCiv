package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class TestEpsilonCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new EpsilonWinnerStrategy(), new AlphaAgeStrategy(), new AlphaActionStrategy(), new DeltaMapStrategy(), new AlphaAttackingStrategy());
	}
	
	@Test
	public void redWinsWhenRedWon3Battles() {
		game.moveUnit(new Position(0, 7), new Position(3, 2));
		game.moveUnit(new Position(0, 12), new Position(3, 4));
		assertThat("When red has won 3 battles, red win", game.getWinner(), is(nullValue()));
		game.moveUnit(new Position(0, 15), new Position(3, 6));
		assertThat("When red has won 3 battles, red win", game.getWinner(), is(Player.RED));
	}
	
	@Test
	public void blueWinsWhenblueWon3Battles() {
		game.endOfTurn();
		game.moveUnit(new Position(3, 2), new Position(0, 7));
		game.moveUnit(new Position(3, 4), new Position(0, 12));
		assertThat("When blue has won 3 battles, blue win", game.getWinner(), is(nullValue()));
		game.moveUnit(new Position(3, 6), new Position(0, 15));
		assertThat("When blue has won 3 battles, blue win", game.getWinner(), is(Player.BLUE));
	}
}
