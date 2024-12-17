package battleship;

public class Cruiser extends Ship {
	final static int cruiserLength = 3;
	
	public Cruiser(){
		super(cruiserLength);
	}
	
	@Override
	public String getShipType() {
		String cruiser = "cruiser";
		return cruiser;
		
		
	}

}
