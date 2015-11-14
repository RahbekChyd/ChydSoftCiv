package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Skeleton class for AlphaCiv test cases

    Updated Oct 2015 for using Hamcrest matchers

   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestAlphaCiv {
  private Game game;
  private Tile tile;

  /** Fixture for alphaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl();
  }

  @Test
  public void shouldHaveRedCityAt1_1() {
    City c = game.getCityAt(new Position(1,1));
    assertThat("There should be a city at (1,1)",
               c, is(notNullValue()));

    Player p = c.getOwner();
    assertThat("The city should be owned by RED player",
               p, is(Player.RED));
  }
  
  @Test
  public void shouldHaveBlueCityAt5_1() {
	  City c = game.getCityAt(new Position(4,1));
	  assertThat("There should be a city at (4,1)", c, is(notNullValue()));
	  
	  Player p = c.getOwner();
	  assertThat("The city should be owned by BLUE player", p, is(Player.BLUE));
  }
  
  @Test
  public void redIsTheFirstPlayer() {
	  Player p = game.getPlayerInTurn();
	  assertThat("Red is the first player in turn", p, is(Player.RED));
  }
  
  @Test
  public void isOceanAt1_0() {
	Tile t = game.getTileAt(new Position(1, 0));
	assertThat("There is ocean at 1, 0", t.getTypeString(), is(GameConstants.OCEANS));
  }
  
  @Test
  public void isHillAt0_1() {
	  Tile t = game.getTileAt(new Position(0, 1));
	  assertThat("There is a hill at 0, 1", t.getTypeString(), is(GameConstants.HILLS));
  }
  
  @Test
  public void isMountainAt2_2() {
	  Tile t = game.getTileAt(new Position(2, 2));
	  assertThat("There is a mountain at 2, 2", t.getTypeString(), is(GameConstants.MOUNTAINS));
  }
  
  @Test
  public void isPlainEverywhereElse() {
	  Tile t = game.getTileAt(new Position(3, 3));
	  Tile t1 = game.getTileAt(new Position(3, 5));
	  assertThat("There is plain everywhere else", t.getTypeString(), is(GameConstants.PLAINS));
	  assertThat("There is plain everywhere else", t1.getTypeString(), is(GameConstants.PLAINS));
  }
  
  @Test
  public void redAfterBlueTurn() {
	  endRoundAfterTurn();
	  assertThat("After Red player turn, it's blue's turn", game.getPlayerInTurn(), is(Player.RED));
  }
  
  @Test
  public void blueAfterRedTurn() {
	  game.endOfTurn();
	  assertThat("After Blue player turn, it's red's turn", game.getPlayerInTurn(), is(Player.BLUE));
  }
  
  @Test
  public void citiesProduce6ProductionsAfterRound() {
	  endRoundAfterTurn();
	  City rc = game.getCityAt(new Position(1,1));
	  City bc = game.getCityAt(new Position(4,1));
	  assertThat("Cities produce 6 'productions' after a round", rc.getAllProduction(), is(6));
	  assertThat("Cities produce 6 'productions' after a round", bc.getAllProduction(), is(6));
	  endRoundAfterTurn();
	  assertThat("Cities produce 6 'productions' after a round", rc.getAllProduction(), is(12));
	  assertThat("Cities produce 6 'productions' after a round", bc.getAllProduction(), is(12));
  }
  
  
  @Test
  public void citiesPopulationSizeIsAlways1() {
	  City rc = game.getCityAt(new Position(1,1));
	  City bc = game.getCityAt(new Position(4,1));
	  assertThat("Cities population size is always 1", rc.getSize(), is(1));
	  assertThat("Cities population size is always 1", bc.getSize(), is(1));
  }
  
  @Test
  public void gameStartInYear4000BC() {
	  assertThat("The game start in year 4000 BC", game.getAge(), is(-4000));
  }
  
  @Test
  public void redWinInYear3000BC() {
	  end5Rounds();
	  end5Rounds();
	  assertThat("Red player win in 3000 BC", game.getWinner(), is(Player.RED));
  }
  
  @Test
  public void redHasInitiallyOneArcherAt2_0() {
	  Unit u = game.getUnitAt(new Position(2,0));
	  assertThat("Red play initially has one archer at 2, 0", u.getOwner(), is(Player.RED));
	  assertThat("Red play initially has one archer at 2, 0", u.getTypeString(), is(GameConstants.ARCHER));
  }
  
  @Test
  public void blueHasOneLegionAt3_2() {
	  Unit u = game.getUnitAt(new Position(3,2));
	  assertThat("Blue has a legion at 3, 2", u.getOwner(), is(Player.BLUE));
	  assertThat("Blue has a legion at 3, 2", u.getTypeString(), is(GameConstants.LEGION));
  }
  
  @Test
  public void redHasASettlerAt4_3() {
	  Unit u = game.getUnitAt(new Position(4, 3));
	  assertThat("Red has a settler at 4, 3", u.getOwner(), is(Player.RED));
	  assertThat("Red has a settler at 4, 3", u.getTypeString(), is(GameConstants.SETTLER));
  }
  
  @Test
  public void onlyOneUnitATile() {
	  assertThat("Only one unit at a tile", game.getUnitAt(new Position(3, 2)), is(notNullValue()));
	  assertThat("Only one unit at a tile", game.getUnitAt(new Position (4,4)), is(nullValue()));
  }
  
  @Test
  public void ifRedAttacksRedWins() {
	  assertThat("If Red attacks blue, red will win", game.moveUnit(new Position(2, 0), new Position(3, 2)), is(true));
  }
  
  public void ifBlueAttackBlueWins() {
	  
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