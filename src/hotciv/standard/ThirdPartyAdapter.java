package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.framework.Strategies.MapStrategy;
import hotciv.standard.Delta.DeltaMapStrategy;
import thirdparty.ThirdPartyFractalGenerator;

public class ThirdPartyAdapter implements MapStrategy{

	@Override
	public Tile[][] tilesMap() {
		ThirdPartyFractalGenerator generator = new ThirdPartyFractalGenerator();
		String[] map = new String[GameConstants.WORLDSIZE];
		String line;
        for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = "";
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                line = line + generator.getLandscapeAt(r,c);
            }
            map[r] = line;
        }
        
        DeltaMapStrategy dStrat = new DeltaMapStrategy();
		return dStrat.generateTiles(map);
	}

	@Override
	public Unit[][] unitsMap() {
		// Do nothing
		return null;
	}

	@Override
	public City[][] cityMap() {
		// Do nothing
		return null;
	}
}
