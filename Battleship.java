package battleship;

public class Battleship extends Ship{
	final static int shipLength = 4;
	
	public Battleship() {		
		super(shipLength);
		
	}
	
	@Override
	public String getShipType() {
		String battleship = "battleship";
		return battleship;
		
		
	}



}
