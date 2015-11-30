package hotciv.standard;

import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class TestDeltaCiv {
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl(new AlphaWinnerStrategy(), new AlphaAgeStrategy(), new AlphaActionStrategy(), new DeltaMapStrategy(), new AlphaAttackingStrategy());
	}
	
	@Test
	public void redCityAt8_12() {
		assertThat("Red city at 8, 12", game.getCityAt(new Position(8, 12)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void blueCityAt4_5() {
		assertThat("Blue city at 4, 5", game.getCityAt(new Position(4, 5)).getOwner(), is(Player.BLUE));
	}
	
	@Test
	public void redArcherAt0_0() {
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 0)).getTypeString(), is(GameConstants.ARCHER));
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 0)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void redArcherAt7_0() {
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 7)).getTypeString(), is(GameConstants.ARCHER));
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 7)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void redArcherAt12_0() {
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 12)).getTypeString(), is(GameConstants.ARCHER));
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 12)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void redArcherAt15_0() {
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 15)).getTypeString(), is(GameConstants.ARCHER));
		assertThat("Red archer at 0, 0", game.getUnitAt(new Position(0, 15)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void blueLegionAt3_2() {
		assertThat("Blue legion at 3, 2", game.getUnitAt(new Position(3, 2)).getTypeString(), is(GameConstants.LEGION));
		assertThat("Blue legion at 3, 2", game.getUnitAt(new Position(3, 2)).getOwner(), is(Player.BLUE));
	}
	
	@Test
	public void redSettlerAt1_2() {
		assertThat("Red settler at 1, 2", game.getUnitAt(new Position(1, 2)).getTypeString(), is(GameConstants.SETTLER));
		assertThat("Red settler at 1, 2", game.getUnitAt(new Position(1, 2)).getOwner(), is(Player.RED));
	}
	
	@Test
	public void oceanAt3_0() {
		assertThat("Ocean at 3, 0", game.getTileAt(new Position(3, 0)).getTypeString(), is(GameConstants.OCEANS));
	}
	
	@Test
	public void plainAt4_0() {
		assertThat("Plain at 4, 0", game.getTileAt(new Position(3, 1)).getTypeString(), is(GameConstants.PLAINS));
	}
	
	@Test
	public void mountainAt6_0() {
		assertThat("Plain at 6, 0", game.getTileAt(new Position(3, 3)).getTypeString(), is(GameConstants.MOUNTAINS));
	}
	
	
}
