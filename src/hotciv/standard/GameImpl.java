package hotciv.standard;

import java.util.ArrayList;

import hotciv.framework.*;

/** Skeleton implementation of HotCiv.

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

public class GameImpl implements Game {
	public Player bluePlayer = Player.BLUE;
	public Player redPlayer = Player.RED;
	public Player playerInTurn = Player.RED;
	private int currentAge = -4000;
	private int turnCounter = 0;
	private int roundCounter = 0;
	Unit[][] units = new Unit[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	Tile[][] tiles = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	City[][] cities = new City[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	private WinnerStrategy strategy;
	private AgeStrategy ageStrategy;
	private ActionStrategy actionStrategy;
	private MapStrategy mapStrategy;
	private AttackStrategy attStrategy;
	
	public GameImpl(WinnerStrategy strategy, AgeStrategy ageStrategy, ActionStrategy actionStrategy, MapStrategy mapStrategy, AttackStrategy attStrategy) {
		this.strategy = strategy;
		this.ageStrategy = ageStrategy;
		this.actionStrategy = actionStrategy;
		this.mapStrategy = mapStrategy;
		this.attStrategy = attStrategy;
		
		units = mapStrategy.unitsMap();
		tiles = mapStrategy.tilesMap();
		cities = mapStrategy.cityMap();
	}

	public Tile getTileAt( Position p ) {
		return tiles[p.getRow()][p.getColumn()];
	}

	public Unit getUnitAt( Position p ) {
		if (units[p.getRow()][p.getColumn()] != null)	
			return units[p.getRow()][p.getColumn()];
		return null; 
	}

	public City getCityAt( Position p ) { 
		if (cities[p.getRow()][p.getColumn()] != null)
			return cities[p.getRow()][p.getColumn()];
		return null; 
	}

	public Player getPlayerInTurn() { 
		return playerInTurn;
	}

	public Player getWinner() {
		return strategy.getWinner(this); 
	}

	public int getAge() { 
		return currentAge;
	}

	public boolean moveUnit( Position from, Position to ) {
		if (getUnitAt(from) == null) {return false;}
		if (getUnitAt(from).getOwner() != playerInTurn) {return false;}
		if (getUnitAt(to) == null && tiles[to.getRow()][to.getColumn()].getTypeString() != GameConstants.PLAINS) {return false;}

		boolean targetTileContainNoUnit = getUnitAt(to) == null;
		boolean targetTileContainNoCity = getCityAt(to) == null;
		if (!targetTileContainNoUnit){
			
			boolean enemyOnTargetTile = getUnitAt(from).getOwner() != (getUnitAt(to).getOwner());
			
			if (enemyOnTargetTile) {
				strategy.addWinningCount(getUnitAt(from).getOwner(), this);
				attStrategy.winnerOfTheBattle(this, from, to);
			}
			return false;
		}
		
		if (!targetTileContainNoCity){
			
			boolean enemyCityOnTargetTile = getUnitAt(from).getOwner() != getCityAt(to).getOwner();
		
			if (enemyCityOnTargetTile) {
				City c = new CityImpl(units[from.getRow()][from.getColumn()].getOwner());
				cities[to.getRow()][to.getColumn()] = c;
				units[from.getRow()][from.getColumn()] = null;
			}
			return false;
		}
		return true;		
	}

	public void endOfTurn() {
		if (getPlayerInTurn() == Player.RED)
			playerInTurn = Player.BLUE;
		else {
			playerInTurn = Player.RED;
		}
		turnCounter += 1;

		if (turnCounter == 2) {
			cities[1][1].updateProduction();
			cities[4][1].updateProduction();
			currentAge += ageStrategy.ageCalculator(this);
			turnCounter = 0;
			roundCounter += 1;
		}
	}
	
	public int getRoundCount() {
		return roundCounter;
	}

	public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
	
	public void changeProductionInCityAt( Position p, String unitType ) {
		City c = getCityAt(p);
		if (unitType.equals(GameConstants.ARCHER))
			c.setProduction(unitType);
		if (unitType.equals(GameConstants.LEGION))
			c.setProduction(unitType);
		if (unitType.equals(GameConstants.SETTLER))
			c.setProduction(unitType);
	}
	
	public void performUnitActionAt( Position p ) {
		actionStrategy.performUnitActionAt(p, this);
	}
	
	public void buildCity (Position p, Player player) {
		if (getUnitAt(p) != null)
			cities[p.getRow()][p.getColumn()] = new CityImpl(getUnitAt(p).getOwner());
		else
			cities[p.getRow()][p.getColumn()] = new CityImpl(player);
	}
	
	public void removeUnit (Position p) {
		units[p.getRow()][p.getColumn()] = null;
	}
	
	public void addUnit (Position p, String type, Player player) {
		units[p.getRow()][p.getColumn()] = new UnitImpl(type, player, p);
	}
	
	public void addTile (Position p, String type) {
		tiles[p.getRow()][p.getColumn()] = new TileImpl(type);
	}

	public void produceUnit(Position p) {
		City c = null;
		if (getCityAt(p) != null)
			c = getCityAt(p);
			if (c.getAllProduction() >= 10 && c.getOwner() == Player.RED) {
				units[p.getRow()][p.getColumn()] = new UnitImpl(c.getProduction(), c.getOwner(), p);
				c.minusProduction(10);
			}
			if (c.getAllProduction() >= 15 && c.getOwner() == Player.BLUE){
				units[p.getRow()][p.getColumn()] = new UnitImpl(c.getProduction(), c.getOwner(), p);
				c.minusProduction(15);
			}
	}

}