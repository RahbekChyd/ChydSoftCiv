package hotciv.standard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;


import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.Factories.AlphaFactory;

public class TestECs {
	private Game game;

	@Before
	public void setUp() {
		game = new GameImpl(new AlphaFactory());
	}

	@Test
	public void redArcherFrom2_0To3_0OccupiedByRedLegion() {
		game.addUnit(new Position(3,0), GameConstants.LEGION, Player.RED);
		assertThat("Red archer move from (2,0) to (3,0) occupied by red legion", game.moveUnit(new Position(2,0), new Position(3,0)), is(false));
	}
	
	@Test
	public void redArcherFrom2_0To4_4ContaiNoUnitAndIsPlain() {
		assertThat("Red Archer move from (2,0) to (4,4) which contain no unit and is plain", game.getUnitAt(new Position(4, 4)), is(nullValue()));
		assertThat("Red Archer move from (2,0) to (4,4) which contain no unit and is plain", game.getTileAt(new Position(4, 4)).getTypeString(), is(GameConstants.PLAINS));
	}
	
	@Test
	public void redArcherFrom2_0To4_4ContaiNoUnitAndIsNotPlain() {
		game.addTile(new Position(4,4), GameConstants.MOUNTAINS);
		assertThat("Red Archer move from (2,0) to (4,4) which contain no unit and is not plain", game.getUnitAt(new Position(4, 4)), is(nullValue()));
		assertThat("Red Archer move from (2,0) to (4,4) which contain no unit and is not plain", game.moveUnit(new Position(2, 0), new Position(4, 4)), is(false));
	}
	
	@Test
	public void moveUnitFrom5_6ContainNoUnit() {
		assertThat("Move unit from (5,6) which contain no unit", game.moveUnit(new Position(5,6), new Position(7,7)), is(false));
	}
	
	@Test
	public void moveUnitFrom5_6ContainUnit() {
		game.addUnit(new Position(5,6), GameConstants.ARCHER, Player.RED);
		assertThat("Move unit from (5,6) which contain no unit", game.moveUnit(new Position(5,6), new Position(7,7)), is(true));
	}
	
	@Test
	public void redTurnMoveRedUnit() {
		assertThat("Red turn move red unit", game.moveUnit(new Position(2,0), new Position(5,5)), is(true));
	}
	
	@Test
	public void redTurnMoveBlueUnit() {
		game.addUnit(new Position(4,4), GameConstants.LEGION, Player.BLUE);
		assertThat("Red turn move red unit", game.moveUnit(new Position(4,4), new Position(5,5)), is(false));
	}
}
