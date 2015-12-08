package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import hotciv.framework.Factory;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.standard.Epsilon.EpsilonAttackingStrategy;
import hotciv.standard.Factories.EpsilonFactory;

public class TestEpsilonCiv {
	private Game game;
	private EpsilonAttackingStrategy attStrat;

	@Before
	public void setUp() {
		Factory fac = new EpsilonFactory(new RollAValue(3));
		game = new GameImpl(fac);
		attStrat = (EpsilonAttackingStrategy) fac.attStrategy();
	}

	@Test
	public void redWinsWhenRedWon3Battles() {
		game.addUnit(new Position(0, 7), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 12), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 15), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(3, 4), GameConstants.LEGION, Player.BLUE);
		game.addUnit(new Position(3, 6), GameConstants.LEGION, Player.BLUE);
		game.moveUnit(new Position(0, 7), new Position(3, 2));
		game.moveUnit(new Position(0, 12), new Position(3, 4));
		assertThat("When red has won 3 battles, red win", game.getWinner(), is(nullValue()));
		game.moveUnit(new Position(0, 15), new Position(3, 6));
		assertThat("When red has won 3 battles, red win", game.getWinner(), is(Player.RED));
	}

	@Test
	public void blueWinsWhenblueWon3Battles() {
		game.addUnit(new Position(0, 7), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 12), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(0, 15), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(3, 4), GameConstants.LEGION, Player.BLUE);
		game.addUnit(new Position(3, 6), GameConstants.LEGION, Player.BLUE);
		game.endOfTurn();
		game.moveUnit(new Position(3, 2), new Position(0, 7));
		game.moveUnit(new Position(3, 4), new Position(0, 12));
		assertThat("When blue has won 3 battles, blue win", game.getWinner(), is(nullValue()));
		game.moveUnit(new Position(3, 6), new Position(0, 15));
		assertThat("When blue has won 3 battles, blue win", game.getWinner(), is(Player.BLUE));
	}

	@Test
	public void redUnitShouldHaveCombinedAttackingStregthOf18() {
		game.addUnit(new Position(12, 12), GameConstants.LEGION, Player.RED);
		game.buildCity(new Position(12, 12), Player.RED);
		game.addUnit(new Position(12, 11), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(11, 12), GameConstants.ARCHER, Player.RED);

		assertThat("combined attack is 18", attStrat.combinedAttackStrength(game, new Position(12, 12)), is(18*3));
	}

	@Test
	public void blueUnitshouldHaveCombinedDefensiveStrengthOf8() {
		game.addUnit(new Position(12 ,12), GameConstants.ARCHER, Player.BLUE);
		Tile t = game.getTileAt(new Position(12, 12));
		t.setTypeString(GameConstants.HILLS);
		game.addUnit(new Position(12, 11), GameConstants.ARCHER, Player.BLUE);

		assertThat("combined defense is 8", attStrat.combinedDefenceStrength(game, new Position(12, 12)), is(8*3));	    }

	@Test
	public void attackerWinFightDefenderDie() {
		assertThat("Current defener is blue", game.getUnitAt(new Position(3, 2)).getOwner(), is(Player.BLUE));
		game.addUnit(new Position(5, 5), GameConstants.ARCHER, Player.RED);
		game.addUnit(new Position(5, 6), GameConstants.LEGION, Player.RED);
		game.moveUnit(new Position(5, 5), new Position(3,2));
		assertThat("Red attacker has moved", game.getUnitAt(new Position(5, 5)), is(nullValue()));
		assertThat("Blue Defender has been killed", game.getUnitAt(new Position(3, 2)).getOwner(), is(Player.RED));
	}

	@Test
	public void DefenderWinFightAttackerDie() {
		Unit u = game.getUnitAt(new Position(3, 2));
		game.moveUnit(new Position(2, 0), new Position(3, 2));
		assertThat("Attacker unit has lost battle and removed", game.getUnitAt(new Position(2, 0)), is(nullValue()));
		assertThat("Defending unit stays", game.getUnitAt(new Position(3, 2)), is(u));
	}
}
