package battleship;
/**
 * This abstract class describes the characteristics common to all ships
 * @author ningwang
 *
 */
public abstract class Ship {
	//The row that contains the bow 
	private int bowRow;
	//The column that contains the bow 
	private int bowColumn;
	//The length of the ship
	private int length;
	//A boolean that represents whether the ship is going to be placed horizontally or vertically
	private boolean horizontal;
	//An array of booleans that indicate whether that part of the ship has been hit or not
	private boolean[] hit;
	
	
	//constructor
	/**
	 * sets the length property of the particular ship and initializes the hit array based on that length
	 * @param length
	 */
	public Ship(int length) {	
		this.length = length;
		this.hit = new boolean[length];
	}
	
	/**
	 * 
	 * @return the ship length
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * 
	 * @return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return this.bowRow;
		
	}
	
	/**
	 * 
	 * @return the bow column location
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}
	/**
	 * 
	 * @return  the hit array
	 */
	public boolean[] getHit() {
		return this.hit;
		
	}
	
	/**
	 * 
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return this.horizontal;
		
	}
	
	/**
	 * Sets the value of bowRow
	 * @param row
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
		
	}
	
	/**
	 * Sets the value of bowColumn
	 * @param column
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	/**
	 * Sets the value of the instance variable horizontal
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/**
	 * Returns the type of ship as a String.
	 * @return
	 */
	public abstract String getShipType();
	
	/**
	 * 
	 * @param row is the given row 
	 * @param column is the given column
	 * @param horizontal is the orientation 
	 * @param ocean
	 * @return true if it is okay to put a ship of this length with its bow in this location; false otherwise.
	 */
	boolean okToPlaceShipAt(int row,int column, boolean horizontal, Ocean ocean) {
		//loop through every location within the ship 
		for (int i = 0; i < this.getLength(); i++) {
			//check if horizontal 
			if(horizontal) {
				//check if column-1 is less than zero 
				if(column-1<0 && i>0) {
					return false;
				}
				//check if i is more than zero 
				if (i>0) {
					//decrease the number of column
					column--;
				}
			//vertical					
			} else {
				//check if row-1 is less than zero 
				if(row-1<0 && i>0) {
					return false;
				}
				//check if i is more than zero 
				if (i>0) {
					//decrease the number of row 
					row--;
				}
				
			}
					
			//check the rows vertically
			for (int j = -1; j<2; j++) {
				//check the column horizontally  
				for (int k=-1; k<2; k++ ) {
					//check if within border 
					if((row+j>=0 && row+j<10) && (column+k >=0 && column+k<10) ){
						//check if it is occupied 
						if (ocean.isOccupied(row+j, column+k)) {
							return false;
						}
					}	
				}					
			}		
		}
				
	return true;
	}
	
	/**
	 * Puts the ship in the ocean.This involves giving values to the bowRow, bowColumn, and 
	 * horizontal instance variables in the ship, and it also involves putting a reference to 
	 * the ship in each of 1 or more locations (up to 4) in the ships array in the Ocean object.
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//set value to bowRow
		this.setBowRow(row);
		//set value to bowColumn
		this.setBowColumn(column);
		//set value to orientation 
		this.setHorizontal(horizontal);
		//check if it is horizontal 
		if (horizontal) {
			//loop through every location within this ship
			for (int i = 0; i <this.getLength(); i++) {
				//set the location to ship 
				ocean.getShipArray()[row][column-i] = this;				
			}
		}
		else {
			//loop through every location within this ship
			for (int j = 0; j < this.getLength(); j++) {
				//set the location to ship 
				ocean.getShipArray()[row-j][column] = this;
				
			}
			
		}
	}
	/**
	 * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
	 * mark that part of the ship as “hit”
	 * @param row
	 * @param column
	 * @return true; otherwise return false.
	 */
	boolean shootAt(int row,int column) {
		
		//set up a initial boolean variable 
		boolean isOccupied = false;
		//set up a initial value to represent which location of ship get shoot 
		int locationShip = 0;	
		// check orientation and bowRow 
		if (this.horizontal == true && this.bowRow == row) {
			//check if column is less than or equal to bowColumn and if the distance between column and bowColumn is less than its length
			if(column <= this.bowColumn && this.bowColumn-column< this.length) {
				//get which part of ship is shot 
				locationShip = this.bowColumn-column;
					// check if the given row/column is occupied
					isOccupied = true;			
			}
		}
		// check orientation and bowColumn
		if (this.horizontal == false && this.bowColumn == column) {
			//check if row is less than or equal to bowRow and if the distance between row and bowRow is less than its length
			if((row <= this.bowRow && this.bowRow-row < this.length)) {
				//get which part of ship is shot 
				locationShip = this.bowRow-row;
				// check if the given row/column is occupied
				isOccupied = true;
				
			}
		}
		
		//check is the given row/column is occupied and if it is sunk 
		if(isOccupied && !this.isSunk()) {
			//change the value of hit 
			this.hit[locationShip] = true;
			return true;
		}		
		return false;
	}
		
	/**
	 * 
	 * @return true if every part of the ship has been hit, false otherwise
	 */
	
	boolean isSunk() {
		//loop through every elements in hit 
		for (int i=0; i< this.getLength(); i++) {
			//check if item in hit is false
			if (this.hit[i] == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  return ”s” if the ship has been sunk and ”x” if it has not been sunk. 
	 */
	@Override
	public String toString() {
		if(this.isSunk() == true) {
			return "s";
		} else {
			return "x";
		}
		
	}




	
	
	
		

}
