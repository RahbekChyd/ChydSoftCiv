package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;

public class CityImpl implements City {
	private Player p;
	private int allProduction;
	private String produc = "";

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
		return produc;
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
	
	public void setProduction(String prod) {
		produc = prod; 
	}

	@Override
	public void minusProduction(int minus) {
		allProduction -= minus;
	}
}