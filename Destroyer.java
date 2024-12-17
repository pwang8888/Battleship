package battleship;

public class Destroyer extends Ship {
	final static int shipLength = 2;
	
	public Destroyer() {		
		super(shipLength);
		
	}
	
	@Override
	public String getShipType() {
		String destroyer = "destroyer";
		return destroyer;
		
		
	}

}
