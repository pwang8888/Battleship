package battleship;

public class Submarine extends Ship {
	final static int shipLength = 1;
	/**
	 * call the constructor in the super class with the appropriate hard-coded length value for each ship
	 */
	public Submarine() {
		super(Submarine.shipLength);
		
	}
	/**
	 * Returns the strings
	 */
	@Override
	public String getShipType() {
		//String submarine = "submarine";
		return "submarine";
		
		
	}

}
