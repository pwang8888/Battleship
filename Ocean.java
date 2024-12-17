package battleship;

public class Ocean {
	
	private Ship[][]ships = new Ship[10][10];
	
	private int shotsFired;
	
	private int hitCount;
	
	private int shipsSunk;
	
	//constructor 
	public Ocean() {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <10; i++) {
				ships[i][j] = new EmptySea();
			}
			
		}
		
		
		
	}
	
	void placeAllShipsRandomly() {
		
	}
	
	boolean isOccupied(int row, int column){
		
	}
	
	boolean shootAt(int row,int column) {
		
	}
	
	int getShotsFired() {
		
	}
	
	int getHitCount() {
		
	}
	int getShipSunk() {
		return this.shipsSunk;
	}
	
	//ask questions about returb value 
	boolean isGameOver() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ships[i][j].isSunk()) {
						count++;
					}
				}
			}
		}
		if(count ==20) {
			return true;
		}
		
		
	
	

}
