package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	Ocean ocean;
	Ship ship;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());
		
		
		//TODO
		//More tests
		
		//test cruiser length 
		ship = new Cruiser();
		assertEquals(3, ship.getLength());
		//test destroyer length 	
		ship = new Destroyer();
		assertEquals(2, ship.getLength());
		//test submarine length
		ship = new Submarine();
		assertEquals(1, ship.getLength());
		
	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//More tests
		//test cruiser vertical placed bowRow
		Ship cruiser = new Cruiser();
		int rowCruiser = 4;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		cruiser.placeShipAt(rowCruiser, columnCruiser, horizontalCruiser, ocean);
		assertEquals(rowCruiser, cruiser.getBowRow());
		
		//test destroyer horizontal placed bowRow 
		Ship destroyer = new Destroyer();
		int rowDestroyer= 8;
		int columnDestroyer= 9;
		boolean horizontalDestroyer = true;
		destroyer.placeShipAt(rowDestroyer, columnDestroyer, horizontalDestroyer, ocean);
		assertEquals(rowDestroyer, destroyer.getBowRow());
		
		
	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());	
		
		//TODO
		//More tests
		//test cruiser vertical placed bowColumn
		Ship cruiser = new Cruiser();
		int rowCruiser = 4;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		cruiser.placeShipAt(rowCruiser, columnCruiser, horizontalCruiser, ocean);
		assertEquals(columnCruiser, cruiser.getBowColumn());
		
		//test destroyer horizontal placed bowColumn 
		Ship destroyer = new Destroyer();
		int rowDestroyer= 8;
		int columnDestroyer= 9;
		boolean horizontalDestroyer = true;
		destroyer.placeShipAt(rowDestroyer, columnDestroyer, horizontalDestroyer, ocean);
		assertEquals(columnDestroyer, destroyer.getBowColumn());
		
	}

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		
		//TODO
		//More tests
		//test submarine's getHit value 
		ship = new Submarine();
		boolean[] hits1 = new boolean[1];
		assertArrayEquals(hits1, ship.getHit());
		assertFalse(ship.getHit()[0]);
		
		//test Cruiser's getHit value 
		ship = new Cruiser();
		boolean[] hits2 = new boolean[3];
		assertArrayEquals(hits2, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		assertFalse(ship.getHit()[2]);
	}
	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());
		
		//TODO
		//More tests
		//test getShipType for submarine
		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());
		
		//test getShipType for EmptySea
		ship = new EmptySea();
		assertEquals("empty", ship.getShipType());
	}
	
	@Test
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//More tests
		//test isHorizontal for cruiser
		Ship cruiser = new Cruiser();
		int rowCruiser = 4;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		cruiser.placeShipAt(rowCruiser, columnCruiser, horizontalCruiser, ocean);
		assertFalse(cruiser.isHorizontal());
		
		//test isHorizontal for destroyer
		Ship destroyer = new Destroyer();
		int rowDestroyer= 8;
		int columnDestroyer= 9;
		boolean horizontalDestroyer = true;
		destroyer.placeShipAt(rowDestroyer, columnDestroyer, horizontalDestroyer, ocean);
		assertTrue(destroyer.isHorizontal());
	}
	
	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//More tests
		//test SetBowRow for cruiser
		Ship cruiser = new Cruiser();
		int rowCruiser = 4;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		cruiser.setBowRow(rowCruiser);
		assertEquals(rowCruiser, cruiser.getBowRow());
	
				
		//test SetBowRow for destroyer
		Ship destroyer = new Destroyer();
		int rowDestroyer= 8;
		int columnDestroyer= 9;
		boolean horizontalDestroyer = true;
		destroyer.setBowRow(rowDestroyer);
		assertEquals(rowDestroyer, destroyer.getBowRow());		
		
	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());
		
		//TODO
		//More tests
		//test getBowColumn for submarine
		Ship submarine = new Submarine();
		int rowSubmarine = 6;
		int columnSubmarine = 4;
		boolean horizontalSubmarine = true;
		submarine.setBowColumn(columnSubmarine);
		assertEquals(column, submarine.getBowColumn());
		
		//test getBowColumn for cruiser
		Ship cruiser = new Cruiser();
		int rowCruiser = 0;
		int columnCruiser = 4;
		boolean horizontalCruiser = true;
		cruiser.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//More tests
		//test isHorizontal for submarine
		Ship submarine = new Submarine();
		int rowSubmarine = 6;
		int columnSubmarine = 4;
		boolean horizontalSubmarine = true;
		submarine.setHorizontal(horizontalSubmarine);
		assertTrue(submarine.isHorizontal());
		
				
		//test isHorizontal for cruiser
		Ship cruiser = new Cruiser();
		int rowCruiser = 0;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		cruiser.setHorizontal(horizontalCruiser);
		assertFalse(cruiser.isHorizontal());
	}

	@Test
	void testOkToPlaceShipAt() {
		
		//test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");
		
		//TODO
		//More tests
		//test OkToPlaceShipAt for submarine
		Ship submarine = new Submarine();
		int rowSubmarine = 6;
		int columnSubmarine = 4;
		boolean horizontalSubmarine = true;
		boolean ok2 = submarine.okToPlaceShipAt(rowSubmarine, columnSubmarine, horizontalSubmarine, ocean);
		assertTrue(ok2, "OK to place ship here.");
		
		//test OkToPlaceShipAt for cruiser
		Ship cruiser = new Cruiser();
		int rowCruiser = 0;
		int columnCruiser = 4;
		boolean horizontalCruiser = false;
		boolean ok3 = cruiser.okToPlaceShipAt(rowCruiser, columnCruiser,horizontalCruiser, ocean);
		assertFalse(ok3, "OK to place ship here.");
	}
	
	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {
		
		//test when other ships are in the ocean
		
		//place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		//test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");
		
		//TODO
		//More tests
		//test third ship 
		Submarine submarine1 = new Submarine();
		int row1 = 5;
		int column1 = 5;
		boolean horizontal1 = true;
		boolean ok3 = submarine1.okToPlaceShipAt(row1, column1, horizontal1, ocean);
		assertTrue(ok3, "OK to place ship here.");
		submarine1.placeShipAt(row, column, horizontal, ocean);
		
		//test fourth ship 
		Submarine submarine2 = new Submarine();
		row1 = 5;
		column1 = 5;
		horizontal1 = true;
		boolean ok4 = submarine2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok4, "Not OK to place ship vertically adjacent below.");
		
		
		
	}

	@Test
	void testPlaceShipAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);
		

		//TODO
		//More tests
	}

	@Test
	void testShootAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = {false, false, false, false};
		assertArrayEquals(hitArray0, battleship.getHit());
		
		//TODO
		//More tests
		//test cruiser 
		Ship cruiser = new Cruiser();
		int row1 = 7;
		int column1 = 6;
		boolean horizontal1 = true;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(cruiser.shootAt(7, 6));
		boolean[] hitArray1 = {true, false, false};
		assertArrayEquals(hitArray1, cruiser.getHit());
		//test destroyer 
		Ship destroyer = new Destroyer();
		int row2 = 3;
		int column2 = 3;
		boolean horizontal2 = true;
		destroyer.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(destroyer.shootAt(3, 3));
		boolean[] hitArray2 = {true, false};
		assertArrayEquals(hitArray2, destroyer.getHit());
		
	}
	
	@Test
	void testIsSunk() {
		
		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());
		
		//TODO
		//More tests
		//test battleship 
		Ship battleship = new Battleship();
		int row1 = 0;
		int column1 = 9;
		boolean horizontal1 = true;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(0, 9));
		assertFalse(submarine.isSunk());
		
		//test cruiser 
		Ship cruiser = new Cruiser();
		int row2 = 7;
		int column2 = 6;
		boolean horizontal2 = true;
		assertFalse(cruiser.isSunk());
		assertFalse(cruiser.shootAt(7, 6));
		assertFalse(cruiser.isSunk());
	}

	@Test
	void testToString() {
		
		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());
		
		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());
		
		//TODO
		//More tests
		//test cruiser 
		Ship cruiser = new Cruiser();
		assertEquals("x", cruiser.toString());
		
		int row1 = 5;
		int column1 = 6;
		boolean horizontal1 = false;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		cruiser.shootAt(5, 6);
		assertEquals("x", cruiser.toString());
		
		
		Submarine submarine1 = new Submarine();
		assertEquals("x", submarine1.toString());
		
		int row2 = 3;
		int column2 = 2;
		boolean horizontal2 = true;
		submarine1.placeShipAt(row1, column1, horizontal1, ocean);
		submarine1.shootAt(3, 2);
		assertEquals("x", submarine1.toString());
		
	}

}
