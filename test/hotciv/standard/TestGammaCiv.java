package hotciv.standard;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class TestGammaCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new GammaFactory());
	}
	
	@Test
	public void redSettlerActionBuildCity() {
		game.performUnitActionAt(new Position(4, 3));
		assertThat("When settler perform action, build city and remove settler", game.getCityAt(new Position (4, 3)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void archerActionActivated() {
		game.performUnitActionAt(new Position(2, 0));
		assertThat("Archer perform action doubles defensive strength", game.getUnitAt(new Position(2, 0)).getDefensiveStrength(), is(6));
	}
	
	@Test
	public void archerActionDeactivated() {
		game.performUnitActionAt(new Position(2, 0));
		assertThat("Archer perform action doubles defensive strength", game.getUnitAt(new Position(2, 0)).getDefensiveStrength(), is(6));
		game.performUnitActionAt(new Position(2, 0));
		assertThat("Archer perfom action again resets defensive strength", game.getUnitAt(new Position(2, 0)).getDefensiveStrength(), is(3));
	}
}
