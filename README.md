# Battleship Game

## Overview

This project implements a **simplified Battleship Game** in Java. It is a console-based, one-player game where the player attempts to sink the computer's fleet of ships placed on a 10x10 grid.

The game demonstrates **Object-Oriented Programming (OOP)** concepts such as inheritance, polymorphism, and encapsulation.

---

## Features

- **Random Ship Placement**: Ships are placed randomly without overlapping or touching.
- **Game Mechanics**:
   - Ships: Battleship (4), Cruiser (3), Destroyer (2), Submarine (1).
   - Shooting: Player shoots at coordinates (row, column).
   - Feedback: Indicates hits, misses, and sunk ships.
- **Grid Display**:
   - `.`: Unfired location  
   - `x`: Hit ship  
   - `-`: Missed shot  
   - `s`: Sunken ship  
- **Game Over**: Game ends when all ships are sunk.

---

## Project Structure

src/ ├── BattleshipGame.java # Main class to run the game ├── Ocean.java # Gameboard and logic for ship placement ├── Ship.java # Abstract class for ship behavior ├── Battleship.java # Battleship ship (length 4) ├── Cruiser.java # Cruiser ship (length 3) ├── Destroyer.java # Destroyer ship (length 2) ├── Submarine.java # Submarine ship (length 1) ├── EmptySea.java # Represents empty spots in the grid ├── ShipTest.java # Unit tests for Ship class └── OceanTest.java # Unit tests for Ocean class
