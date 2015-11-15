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
	public City redCity = new CityImpl(Player.RED);
	public City blueCity = new CityImpl(Player.BLUE);
	private int currentAge = -4000;
	private int turnCounter = 0;
	Unit[][] units = new Unit[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	Tile[][] tiles = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	
	public GameImpl() {
	    for (int i = 0; i<GameConstants.WORLDSIZE; i++){
	        for (int j = 0; j<GameConstants.WORLDSIZE; j++){
	          tiles[i][j] = new TileImpl(GameConstants.PLAINS);
	        }
	      }
	    
	    tiles[1][0] = new TileImpl(GameConstants.OCEANS);
	    tiles[0][1] = new TileImpl(GameConstants.HILLS);
	    tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		
		units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED, new Position(2, 0));
		units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE, new Position(3, 2));
		units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED, new Position(4, 3));
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
		if (p.getRow() == 1 && p.getColumn() == 1)
			return redCity;
		if (p.getRow() == 4 && p.getColumn() == 1)
			return blueCity;
		return null; 
	}
	
	public Player getPlayerInTurn() { 
		return playerInTurn;
		}
	
	public Player getWinner() {
		if (getAge() == -3000)
			return redPlayer;
		return null; 
		}
	
	public int getAge() { 
		return currentAge;
		}
	
	public boolean moveUnit( Position from, Position to ) {
		if (getUnitAt(from) == null) {return false;}
		if (getUnitAt(from).getOwner() != playerInTurn) {return false;}
		if (getUnitAt(to) == null && tiles[to.getRow()][to.getColumn()].getTypeString() != GameConstants.PLAINS) {return false;}
		
		boolean targetTileContainNoUnit = getUnitAt(to) == null;
		if (!targetTileContainNoUnit){
			boolean enemyOnTargetTile = getUnitAt(from).getOwner() != (getUnitAt(to).getOwner());

			if (enemyOnTargetTile) {
				units[to.getRow()][to.getColumn()] = units[from.getRow()][from.getColumn()];
				units[from.getRow()][from.getColumn()] = null;
			}
			else return false;
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
			redCity.updateProduction();
			blueCity.updateProduction();
			currentAge += 100;
			turnCounter = 0;
		}
	}
	
	public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
	public void changeProductionInCityAt( Position p, String unitType ) {}
	public void performUnitActionAt( Position p ) {}
}
