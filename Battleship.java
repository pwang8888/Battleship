package battleship;

public class Battleship extends Ship{
	final static int shipLength = 4;
	/**
	 * call the constructor in the super class with the appropriate hard-coded length value for each ship
	 */
	public Battleship() {		
		super(Battleship.shipLength);
		
	}
	/**
	 *  return the strings
	 */
	@Override
	public String getShipType() {
		//String battleship = "battleship";
		return "battleship";
		
		
	}



}
