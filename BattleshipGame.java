package battleship;

import java.util.Scanner;

public class BattleshipGame {
	/**
	 * This is the main method to run the game
	 * @param args
	 */
	public static void main(String[] args) {
		BattleshipGame game  = new BattleshipGame();
		game.runGame();
;		
	}
	
	/**
	 * run Game and ask user to input 
	 * 
	 */
	public void runGame() {
		//start a new ocean 
		Ocean ocean = new Ocean();
		//place ship randomly
		ocean.placeAllShipsRandomly();
		//set up a new scanner
		Scanner scanner = new Scanner(System.in);
		//print the ocean 
		ocean.printWithShips();
		ocean.print();
		//check if game if over 
		while(ocean.isGameOver() == false) {
			//display the hit count
			System.out.println("Hit Count: " + ocean.getHitCount());
			//display the Ship Sunk Count
			System.out.println("Ships Sunk Count: " + ocean.getShipsSunk());
			//instructions for user to enter number 
			System.out.print("Enter row, column(seperate by comma):");
			//get the input
			String input = scanner.nextLine();
			//divided by ,
			String[] inputArray= input.split(",");
			//check the input length
			if (inputArray.length==2) {
				//get the first element and remove space 
				String r = inputArray[0].trim();
				//get the second element and remove space 
				String col = inputArray[1].trim();	
				//try to parse string to integer 
				try {
					int row =Integer.parseInt(r);
					int column =Integer.parseInt(col);		
					//check if given location is shoot at ship
					if(ocean.shootAt(row, column)) {
						//print hit message 
						System.out.println("hit!");
						Ship[][] ships = ocean.getShipArray();
						//check if given location is sunk and print sank message and ship type 
						if (ships[row][column].isSunk()) {
							System.out.println("You just sank a ship-" +ships[row][column].getShipType() + ".");
						}
					//if not hit, print miss message 
					} else {
						System.out.println("Miss");
					}
					//print ocean
					ocean.print();
				//if not, ask user to put number 
				} catch (NumberFormatException e) {
					System.out.println("please enter numbers!");
					continue;
				}
			//print out invalid message of the input length is not 2
			} else {
				System.out.println("Invalid");				
			}
			//print final score and ask user if they want to play again 
			
			}
		System.out.println("Final score: " + ocean.getShotsFired());
		System.out.println("Play again?(Y or N)");
		String playAgain = scanner.next();
		//if user want to play again, then run the game.
		if( playAgain.toLowerCase().trim().equals("y")) {
			this.runGame();
		
	}
	}
}
