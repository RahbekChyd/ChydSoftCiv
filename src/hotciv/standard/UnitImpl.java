package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.ThetaConstants;
import hotciv.framework.Unit;

public class UnitImpl implements Unit {
	private String type;
	private Player owner;
	private Position pos;
	private boolean bonus = false;
	private int moveCount;

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
		return moveCount;
	}

	@Override
	public int getDefensiveStrength() {
		if (type == GameConstants.ARCHER) {
			if (bonus)
				return 6;
			return 3;
		}
		if (type == GameConstants.LEGION)
			return 2;
		if (type == GameConstants.SETTLER)
			return 3;
		if (type == ThetaConstants.Chariot) {
			if (bonus)
				return 2;
			return 1;
		}
		return 0;
	}

	@Override
	public int getAttackingStrength() {
		if (type == GameConstants.ARCHER)
			return 2;
		if (type == GameConstants.LEGION)
			return 4;
		if (type == GameConstants.SETTLER)
			return 0;
		if (type == ThetaConstants.Chariot)
			return 3;
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
		else if (type == ThetaConstants.Chariot)
			return ThetaConstants.Chariot;
		return type;
	}

	@Override
	public void actionBonus() {
		if (bonus)
			bonus = false;
		else bonus = true;	
	}
}