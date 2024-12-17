package battleship;

public class EmptySea extends Ship {
	public EmptySea(){
		super(1);
	}
	
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "-";
		
	}
	
	@Override
	public String getShipType() {
		return " ";
		
	}
}
