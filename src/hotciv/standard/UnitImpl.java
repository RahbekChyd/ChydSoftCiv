package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

public class UnitImpl implements Unit {
	private String type;
	private Player owner;
	private Position pos;

	public UnitImpl(String type, Player owner, Position p) {
		this.type = type;
		this.owner = owner;
		this.pos = p;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getMoveCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDefensiveStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAttackingStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Position getPosition() {
		return pos;
	}

	@Override
	public String getTypeString() {
		if (type == GameConstants.ARCHER)
			return GameConstants.ARCHER;
		else if (type == GameConstants.LEGION)
			return GameConstants.LEGION;
		else if (type == GameConstants.SETTLER)
			return GameConstants.SETTLER;
		return type;
	}

}