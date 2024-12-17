package battleship;

public class Cruiser extends Ship {
	final static int cruiserLength = 3;
	
	
	/**
	 * call the constructor in the super class with the appropriate hard-coded length value for each ship
	 */
	public Cruiser(){
		super(Cruiser.cruiserLength);
	}
	/**
	 * Returns one of the strings
	 */
	@Override
	public String getShipType() {
		
		return "cruiser";
		
		
	}

}
