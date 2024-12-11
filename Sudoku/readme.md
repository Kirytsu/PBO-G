Version : 0.1

Author: Nathanael Valen Susilo

# Sudoku Game

## Overview
This is a simple Sudoku game built using Java and Swing for the graphical user interface (GUI). The game allows the user to play Sudoku, with features such as a timer, difficulty selection, and automatic board generation. The game checks for valid input, and upon submitting the solution, it checks whether the user has solved the puzzle correctly or not.

## Features
- **Sudoku Grid**: A 9x9 grid to fill in numbers.
- **Timer**: A countdown timer to challenge the player.
- **Difficulty Levels**: Easy, Medium, and Hard difficulty options that influence the puzzle's maximum clear time.
- **Validation**: The game validates the user's input against the solution and highlights any incorrect cells in red with bold text.
- **Start and Submit**: Options to start a new game and submit the solution.
- **Game Over**: Displays a "You Win!" or "You Lose" message based on the result.

## Requirements
- Java 14 or higher.
- A text editor or an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans.

## Manual
1. Clone the repository.
2. Navigate to the project directory.
3. Run the `SudokuMain.java` file to start the game.

## How to Play
1. Select a difficulty level (Easy, Medium, or Hard).
2. A new Sudoku puzzle will be generated, and the timer will start.
3. Fill in the empty cells with numbers from 1 to 9, ensuring that each number in a row, column, and 3x3 subgrid is unique.
4. Once you're done, click the "Submit" button to check if your solution is correct.
5. If the puzzle is solved correctly, you will see a "You Win!" message. Otherwise, incorrect cells will be highlighted in red, and you will be informed with a "You Lose" message.

## Game Logic
The game uses a **constraint satisfaction problem (CSP)** approach to ensure the puzzle is valid. The Sudoku puzzle's constraints ensure that each row, column, and 3x3 subgrid contains the numbers 1 through 9 without repetition.

- **Grid Variables**: Each cell on the grid is a variable.
- **Domain**: The domain for each variable is the set of numbers {1, 2, 3, 4, 5, 6, 7, 8, 9}.
- **Constraints**: The constraints ensure that no number repeats within a row, column, or 3x3 subgrid.

## Code Structure
- **SudokuMain.java**: Entry to start the game.
- **SudokuGame.java**: Sets up the GUI.
- **SudokuEventHandler.java**: Manages user input, handles start and submit actions, and updates the game state.
- **SudokuGenerator.java**: Responsible for generating valid Sudoku puzzle.
- **SudokuSolver.java**: Contains the logic for checking and solving the Sudoku puzzle.


