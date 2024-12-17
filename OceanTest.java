package battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {

	Ocean ocean;
	
	static int NUM_BATTLESHIPS = 1;
	static int NUM_CRUISERS = 2;
	static int NUM_DESTROYERS = 3;
	static int NUM_SUBMARINES = 4;
	static int OCEAN_SIZE = 10;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}
	
	@Test
	void testEmptyOcean() {
		
		//tests that all locations in the ocean are "empty"
		
		Ship[][] ships = ocean.getShipArray();
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				
				assertEquals("empty", ship.getShipType());
			}
		}
		
		assertEquals(0, ships[0][0].getBowRow());
		assertEquals(0, ships[0][0].getBowColumn());
		
		assertEquals(5, ships[5][5].getBowRow());
		assertEquals(5, ships[5][5].getBowColumn());
		
		assertEquals(9, ships[9][0].getBowRow());
		assertEquals(0, ships[9][0].getBowColumn());
	}
	
	@Test
	void testPlaceAllShipsRandomly() {
		
		//tests that the correct number of each ship type is placed in the ocean
		
		ocean.placeAllShipsRandomly();

		Ship[][] ships = ocean.getShipArray();
		ArrayList<Ship> shipsFound = new ArrayList<Ship>();
		
		int numBattlehips = 0;
		int numCruisers = 0;
		int numDestroyers = 0;
		int numSubmarines = 0;
		int numEmptySeas = 0;
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				if (!shipsFound.contains(ship)) {
					shipsFound.add(ship);
				}
			}
		}
		
		for (Ship ship : shipsFound) {
			if ("battleship".equals(ship.getShipType())) {		
				numBattlehips++;
			} else if ("cruiser".equals(ship.getShipType())) {
				numCruisers++;
			} else if ("destroyer".equals(ship.getShipType())) {
				numDestroyers++;
			} else if ("submarine".equals(ship.getShipType())) {
				numSubmarines++;
			} else if ("empty".equals(ship.getShipType())) {
				numEmptySeas++;
			}
		}
		
		assertEquals(NUM_BATTLESHIPS, numBattlehips);
		assertEquals(NUM_CRUISERS, numCruisers);
		assertEquals(NUM_DESTROYERS, numDestroyers);
		assertEquals(NUM_SUBMARINES, numSubmarines);
		
		//calculate total number of available spaces and occupied spaces
		int totalSpaces = OCEAN_SIZE * OCEAN_SIZE; 
		int occupiedSpaces = (NUM_BATTLESHIPS * 4)
				+ (NUM_CRUISERS * 3)
				+ (NUM_DESTROYERS * 2)
				+ (NUM_SUBMARINES * 1);
		
		//test number of empty seas, each with length of 1
		assertEquals(totalSpaces - occupiedSpaces, numEmptySeas);
	}

	@Test
	void testIsOccupied() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.isOccupied(1, 5));
		
		//TODO
		//More tests
		//test a battleship 
		Battleship battleship = new Battleship();
		int row1 = 3;
		int column1 = 3;
		boolean horizontal1 = false;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		Ship submarine2 = new Submarine();
		row1 = 5;
		column1 = 6;
		horizontal1 = false;
		submarine2.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.isOccupied(3, 3));
		
		//test a cruiser 
		Cruiser cruiser = new Cruiser();
		int row2 = 7;
		int column2 = 8;
		boolean horizontal2= false;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		Ship submarine3 = new Submarine();
		row2 = 3;
		column2 = 3;
		horizontal2 = false;
		submarine3.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.isOccupied(7, 8));
	}

	@Test
	void testShootAt() {
	
		assertFalse(ocean.shootAt(0, 1));
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		
		
		//TODO
		//More tests
		//test for a battleship 
		assertFalse(ocean.shootAt(7, 8));
		
		Battleship battleship = new Battleship();
		int row1 = 4;
		int column1 = 4;
		boolean horizontal1 = true;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(4, 3));
		assertFalse(battleship.isSunk());
		assertTrue(ocean.shootAt(4, 2));
		
		//test for a cruiser 
		assertFalse(ocean.shootAt(6, 7));
		
		Cruiser cruiser = new Cruiser();
		int row2 = 6;
		int column2 = 6;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(6, 6));
		assertFalse(cruiser.isSunk());
		assertTrue(ocean.shootAt(6, 4));
		
	}

	@Test
	void testGetShotsFired() {
		
		//should be all false - no ships added yet
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 0));
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(9, 9));
		assertEquals(4, ocean.getShotsFired());
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(6, ocean.getShotsFired());
		ocean.print();
		
		//TODO
		//More tests
		//add a new battleship to test 
		Battleship battleship = new Battleship();
		int row1 = 4;
		int column1 = 4;
		boolean horizontal1 = true;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(4, 4));
		assertFalse(battleship.isSunk());
		assertTrue(ocean.shootAt(4, 3));
		assertFalse(battleship.isSunk());
		assertEquals(8, ocean.getShotsFired());
		
		//add a new cruiser to test 
		Cruiser cruiser = new Cruiser();
		int row2 = 6;
		int column2 = 5;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(6, 5));
		assertFalse(cruiser.isSunk());
		assertTrue(ocean.shootAt(6, 4));
		assertFalse(cruiser.isSunk());
		assertEquals(10, ocean.getShotsFired());
		
		
	}

	@Test
	void testGetHitCount() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		
		//TODO
		//More tests
		//add a new battleship to test 
		Battleship battleship = new Battleship();
		int row1 = 4;
		int column1 = 4;
		boolean horizontal1 = true;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(4, 4));
		assertFalse(battleship.isSunk());
		assertEquals(2, ocean.getHitCount());
		//add a new cruiser to test
		Cruiser cruiser = new Cruiser();
		int row2 = 6;
		int column2 = 5;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(4, 4));
		assertFalse(battleship.isSunk());
		assertEquals(3, ocean.getHitCount());
		
		
	}
	
	@Test
	void testGetShipsSunk() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
		
		//TODO
		//More tests
		//test submarine
		Submarine submarine = new Submarine();
		int row1 = 4;
		int column1 = 4;
		boolean horizontal1 = true;
		submarine.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(4, 4));
		assertTrue(submarine.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
		//add a new cruiser to test
		Cruiser cruiser = new Cruiser();
		int row2 = 6;
		int column2 = 5;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(6, 5));
		assertFalse(cruiser.isSunk());
		assertEquals(3, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
	}

	@Test
	void testGetShipArray() {
		
		Ship[][] shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);
		
		assertEquals("empty", shipArray[0][0].getShipType());
		
		//TODO
		//More tests
		//test submarine
		Submarine submarine = new Submarine();
		int row1 = 4;
		int column1 = 4;
		boolean horizontal1 = true;
		submarine.placeShipAt(row1, column1, horizontal1, ocean);
		assertEquals("submarine", shipArray[4][4].getShipType());
		//add a new cruiser to test
		Cruiser cruiser = new Cruiser();
		int row2 = 6;
		int column2 = 5;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertEquals("cruiser", shipArray[6][5].getShipType());
		
	}

}
