package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;

public class CityImpl implements City {
	private Player p;
	private int allProduction;
	
	public CityImpl(Player p){
		this.p = p;
	}

	@Override
	public Player getOwner() {
		if (p == p.RED)
			return Player.RED;
		if (p == p.BLUE)
			return Player.BLUE;
		return null;
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String getProduction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWorkforceFocus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateProduction() {
		allProduction += 6;
	}
	
	public int getAllProduction() {
		return allProduction;
	}
}
