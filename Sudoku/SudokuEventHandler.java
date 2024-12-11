import javax.swing.*;
import java.util.Arrays;
import java.awt.Color; 
import javax.swing.Box;

public class SudokuEventHandler {
    private final JTextField[][] grid;
    private final JLabel timerLabel;
    private final Timer timer;
    private final JButton startButton;
    private final JButton submitButton;
    private final ButtonGroup difficultyGroup;
    private final JRadioButton easyButton;
    private final JRadioButton mediumButton;
    private final JRadioButton hardButton;
    private boolean isStarted = false;
    private int[][] prevBoard = new int[9][9];
    private int timeCount;

    public SudokuEventHandler(JTextField[][] grid, JLabel timerLabel, Timer timer,
                              JButton startButton, JButton submitButton, ButtonGroup difficultyGroup,
                              JRadioButton easyButton, JRadioButton mediumButton, JRadioButton hardButton) {
        this.grid = grid;
        this.timerLabel = timerLabel;
        this.timer = timer;
        this.startButton = startButton;
        this.submitButton = submitButton;
        this.difficultyGroup = difficultyGroup;
        this.easyButton = easyButton;
        this.mediumButton = mediumButton;
        this.hardButton = hardButton;
    }

    private void resetGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j].setForeground(null);
                grid[i][j].setFont(grid[i][j].getFont().deriveFont(java.awt.Font.PLAIN)); 
            }
        }
    }

    private void setFalseGrid(int i, int j, int solution){
            grid[i][j].setForeground(Color.RED); 
            grid[i][j].setFont(grid[i][j].getFont().deriveFont(java.awt.Font.BOLD)); 
            grid[i][j].setText(Integer.toString(solution));
            grid[i][j].setEditable(false);
    }
    
    private boolean validateGrid(int[][] solution) {
        boolean res = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String cellValue = grid[i][j].getText().trim();
                try {
                    // Check if the user input matches the solution
                    if (Integer.parseInt(cellValue) != solution[i][j]) {
                        setFalseGrid(i, j, solution[i][j]);
                        res = false;
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    setFalseGrid(i, j, solution[i][j]);
                    res = false;
                }
            }
        }
        return res;  
    }


    public void updateTimer() {
        if (timeCount > 0) {
            timeCount--;
            int minutes = timeCount / 60;
            int seconds = timeCount % 60;
            timerLabel.setText(String.format("Time Left: %02d:%02d", minutes, seconds));
        } else {
            timer.stop();
            JOptionPane.showMessageDialog(null, "Time's up! You Lose.");
            handleStart(); // Reset game state
        }
    }

    //Handle Start and Give Up Button
    public void handleStart() {
        //Give Up
        if (isStarted) {
            isStarted = false;
            resetGrid();
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j].setEditable(false);
                    grid[i][j].setText(Integer.toString(prevBoard[i][j]));
                }
            }
            startButton.setText("Start");
            timer.stop();
            timerLabel.setVisible(false);
            submitButton.setVisible(false);
        } else { 
            //Start
            resetGrid();
            int difficulty = 1; // Default is medium
            if (difficultyGroup.getSelection() != null) {
                if (difficultyGroup.getSelection() == easyButton.getModel()) difficulty = 0;
                else if (difficultyGroup.getSelection() == hardButton.getModel()) difficulty = 2;
            }

            timeCount = switch (difficulty) {
                case 0 -> 900;
                case 1 -> 600;
                case 2 -> 300;
                default -> 600;
            };

            int[][] board;
            do {
                board = SudokuGenerator.generate(difficulty);
            } while (board[0][0] == -1);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != 0) {
                        grid[i][j].setText(Integer.toString(board[i][j]));
                    } else {
                        grid[i][j].setText("");
                        grid[i][j].setEditable(true);
                    }
                }
            }
            
            prevBoard = SudokuSolver.solve(board);
            submitButton.setVisible(true);
            startButton.setText("Give up!");
            timerLabel.setVisible(true);
            timer.start();
            isStarted = true;
        }
    }

    //Handle submit button
    public void handleSubmit() {
        timerLabel.setVisible(false);
        timer.stop();
        boolean isFine = validateGrid(prevBoard);
        if (isFine && isStarted) {
            JOptionPane.showMessageDialog(null, "You Won.");
        } else if (!isStarted){
            JOptionPane.showMessageDialog(null, "You haven't start the game.");
        } else {
            JOptionPane.showMessageDialog(null, "You Lose.");
        }

        isStarted = false;
        startButton.setText("Start");
    }
}
