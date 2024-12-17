Battleship Game
Overview
A simplified, console-based Battleship Game implemented in Java. The player competes against the computer to sink all ships on a 10x10 grid using the fewest shots.

Features
Random Ship Placement: Ships are placed randomly without overlapping.
Game Logic: Includes Battleship, Cruiser, Destroyer, and Submarine.
User Feedback: Displays hits, misses, and sunken ships.
Object-Oriented Design: Uses inheritance, encapsulation, and polymorphism.
Project Structure
bash
Copy code
src/
├── BattleshipGame.java      # Main game logic
├── Ocean.java               # Gameboard and ship placement
├── Ship.java                # Abstract ship class
├── [ShipType].java          # Battleship, Cruiser, Destroyer, Submarine
├── EmptySea.java            # Represents empty ocean space
├── ShipTest.java            # Unit tests for Ship class
└── OceanTest.java           # Unit tests for Ocean class
