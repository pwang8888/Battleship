package battleship;

public class Submarine extends Ship {
	final static int shipLength = 1;
	public Submarine() {
		super(shipLength);
		
	}
	
	@Override
	public String getShipType() {
		String submarine = "submarine";
		return submarine;
		
		
	}

}
