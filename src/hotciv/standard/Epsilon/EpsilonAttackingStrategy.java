package hotciv.standard.Epsilon;

import hotciv.framework.Dice;
import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Strategies.AttackStrategy;
import hotciv.standard.Utility;

public class EpsilonAttackingStrategy implements AttackStrategy {
	private Dice dice;
	
	public EpsilonAttackingStrategy(Dice dice) {
		this.dice = dice;
	}

	@Override
	public void winnerOfTheBattle(Game game, Position from, Position to) {
		if (combinedAttackStrength(game, from) > combinedDefenceStrength(game, to)) {
			game.removeUnit(to);
			game.addUnit(to, game.getUnitAt(from).getTypeString(), game.getUnitAt(from).getOwner());
			game.removeUnit(from);
		}
		else {
			game.removeUnit(from);
		}
	}

	public int combinedAttackStrength(Game game, Position p) {
		int terrainFactor = Utility.getTerrainFactor(game, p);
		int friendlySupport = Utility.getFriendlySupport(game, p, game.getUnitAt(p).getOwner());
		int combinedStrength = ((game.getUnitAt(p).getAttackingStrength() + friendlySupport) * terrainFactor);
		return combinedStrength * dice.getValue();
	}
	
	public int combinedDefenceStrength(Game game, Position p) {
		int terrainFactor = Utility.getTerrainFactor(game, p);
		int friendlySupport = Utility.getFriendlySupport(game, p, game.getUnitAt(p).getOwner());
		int combinedStrength = ((game.getUnitAt(p).getDefensiveStrength() + friendlySupport) * terrainFactor);
		return combinedStrength * dice.getValue();
	}
}
