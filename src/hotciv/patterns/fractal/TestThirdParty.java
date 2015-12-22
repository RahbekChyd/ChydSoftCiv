package hotciv.patterns.fractal;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.standard.Factories.ThirdPartyFactory;

public class TestThirdParty {
	
	  public static void main(String[] args) {
		  	Game game = new GameImpl(new ThirdPartyFactory());
		    String line;
		    System.out.println("Demonstration of the fractal landscape generator");
		    for ( int r = 0; r < 16; r++ ) {
		      line = "";
		      for ( int c = 0; c < 16; c++ ) {
		        line = line + game.getTileAt(new Position(r,c)).getTypeString().charAt(0);
		      }
		      System.out.println( line );
		    }
		  }
}
