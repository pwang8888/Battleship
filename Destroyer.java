package battleship;

public class Destroyer extends Ship {
	final static int shipLength = 2;
	/**
	 * call the constructor in the super class with the appropriate hard-coded length value for each ship
	 */
	public Destroyer() {		
		super(Destroyer.shipLength);
		
	}
	/**
	 * return the strings
	 */
	@Override
	public String getShipType() {
		//String destroyer = "destroyer";
		return "destroyer";
		
		
	}

}
