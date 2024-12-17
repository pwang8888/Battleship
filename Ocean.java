package battleship;

import java.util.Random;

public class Ocean {
	
	/**
	 * Used to quickly determine which ship is in any given location
	 */
	private Ship[][]ships = new Ship[10][10];
	
	/**
	 * Used to determine the location of fired 
	 */
	boolean[][] fired = new boolean[10][10];
	
	/**
	 * The total number of shots fired by the user
	 */
	private int shotsFired;
	
	/**
	 * The number of times a shot hit a ship.
	 */
	private int hitCount;
	/**
	 * The number of ships sunk (10 ships in all)
	 */
	private int shipsSunk;
	
	//constructor 
	/**
	 * Creates an ”empty” ocean (and fills the ships array with EmptySea objects).
	 */
	public Ocean() {
		//iterate every elements in ships
		for (int i = 0; i < this.getShipArray().length; i++) {
			for (int j = 0; j < this.getShipArray().length; j++) {
				//initialize emptySea
				Ship emptyShip = new EmptySea();
				//set up bowRow 
				emptyShip.setBowRow(i);
				//set up bowColumn
				emptyShip.setBowColumn(j);
				//set up empty sea
				ships[i][j] = emptyShip;
				//set up fired to false 
				fired[i][j]= false;
			}
			
		}
				
	}
	/**
	 * place one ship randomly on the ocean
	 */
	
	private void placeOneShipRandomly(Ship ship) {
		//create boolean array 
		boolean[] options = { true, false};
		//create new instance for random
		Random random = new Random();
		//create variables for random row, column, and boolean 
		int ranRow;
		int ranCol;
		boolean ranBol;
		//generate random number for row, column and boolean
		while(true) {
			//generate random number from 0-9
			ranRow = random.nextInt(10);
			//generate random number from 0-9
			ranCol = random.nextInt(10);
			//generate value from options
			ranBol = options[random.nextInt(2)];
			//check if the place is qualified to place 
			if(ship.okToPlaceShipAt(ranRow, ranCol, ranBol, this)) {
				//place the ship at the random place 
				ship.placeShipAt(ranRow, ranCol, ranBol, this);
				break;
			// if not generate another random number 
			} else {
				//generate random number from 0-9
				ranRow = random.nextInt(10);
				//generate random number from 0-9
				ranCol = random.nextInt(10);
				//generate value from options
				ranBol = options[random.nextInt(2)];
				
			}
			
		}

	}
	
	
	/**
	 * Place all ten ships randomly on the (initially empty) ocean. 
	 */
	void placeAllShipsRandomly() {
		//create a list of ships
		Ship[] ships = { new Battleship(), new Cruiser(), new Cruiser(), new Destroyer(), new Destroyer(), 
				new Destroyer(), new Submarine(), new Submarine(), new Submarine(), new Submarine()};
		//loop through every elements in this ship 
		for (Ship ship: ships) {
			//place one ship randomly
			placeOneShipRandomly(ship);		
		}
	}
	/**
	 * 
	 * @param row
	 * @param column
	 * @return true if the given location contains a ship, false if it does not
	 */
	boolean isOccupied(int row, int column){
		//check if input is out of border 
		if (row < 0||row >9 || column < 0 ||column > 9) return false;
		//check if given location is emptySea
		if(ships[row][column]instanceof EmptySea) {
			return false;
		} 
		return true; 	
	}
		
	
	/**
	 * this method updates the number of shots that have been fired, and the number of hits
	 * @param row
	 * @param column
	 * @return true if the given location contains a ”real” ship, 
	 * still afloat, (not an EmptySea), false if it does not. 
	 */
	boolean shootAt(int row,int column) {
		//check if the given location is out of border 
		if (row < 0||row >9 || column < 0 ||column > 9) return false;
		//update the value of fired 
		fired[row][column] = true;
		//check if the given location is empty and if the ship is sunk
		if (getShipArray()[row][column].getShipType() != "empty" && getShipArray()[row][column].isSunk()== false) {
			// increase the hits/shots count
			this.hitCount ++;	
			//increase shotsFired 
			this.shotsFired ++;
			// shoot the ship
			getShipArray()[row][column].shootAt(row, column);
				//check if ship is sunk after shoot
				if(getShipArray()[row][column].isSunk()) {
					//increase shoot number
					this.shipsSunk ++;
				}
			return true;
		}

		// check if it's an empty sea
		else if (getShipArray()[row][column].getShipType() == "empty") {
			// still conduct shooting, but not returning true
			// increasing shut counts only
			this.shotsFired ++;
			getShipArray()[row][column].shootAt(row, column);
		}
		
		return false;
	}
	/**
	 * 
	 * @return the number of shots fired 
	 */
	int getShotsFired() {
		return this.shotsFired;
		
	}
	/**
	 * 
	 * @return the number of hits recorded
	 */
	int getHitCount() {
		return this.hitCount;
		
	}
	/**
	 * 
	 * @return the number of ships sunk
	 */
	int getShipsSunk() {
		return this.shipsSunk;
	}
	/**
	 * 
	 * @return true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		//check all the elements is sunk 
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ships[i][j].isSunk()) {
					count++;
				}
			}
		}
		//the count should be 20 if all ships are sunk 
		if(count == 20) {
		return true;
		}
		return false;
		
	}
	/**
	 * 
	 * @return the 10x10 array of Ships
	 */
	Ship[][] getShipArray(){
		return this.ships;
		
	}
	/**
	 * Prints the Ocean. 
	 */
	void print() {
		//print the first line
		System.out.println("   0 1 2 3 4 5 6 7 8 9");
	
		for (int i = 0; i < 10; i++) {
			//print the first number in each row 
		    System.out.print(i + " ");
		    for (int j = 0; j < 10; j++) {
		    	//check if the location is fired 
		        if (!fired[i][j]) {
		        	//print dot if not
		            System.out.print(" .");
		        } else {
		        	//print ships String 
		            System.out.print(" " + ships[i][j].toString());
		        }
		    }
		    System.out.println(" ");
		}
	
	}
		    
		
	/**
	 * USED FOR DEBUGGING PURPOSES ONLY.
	 */
	
	void printWithShips() {
		System.out.println("   0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < 10; i++) {
		    System.out.print(i +"  ");
		    for (int j = 0; j < 10; j++) {
		      
		            if (ships[i][j].getShipType() == "cruiser") {
		            	System.out.print("C ");
		            } else if (ships[i][j].getShipType() == "battleship"){
		            	System.out.print("B ");
		            } else if (ships[i][j].getShipType() == "destroyer"){
		            	System.out.print("D ");
		            } else if (ships[i][j].getShipType() == "submarine"){
		            	System.out.print("S ");
		            } else {
		            	System.out.print("  ");
		            }
		            
		        }
		    System.out.println();
		    }
		}
}
	
	

	
	
	
	
	
	
	
	
	
	
	


