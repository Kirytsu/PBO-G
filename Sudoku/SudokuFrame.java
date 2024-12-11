import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuFrame extends JFrame {
    private final JTextField[][] grid = new JTextField[9][9];
    private final JLabel timerLabel = new JLabel("Time Left:");
    private final JButton startButton = new JButton("Start");
    private final JButton submitButton = new JButton("Submit");
    private final ButtonGroup difficultyGroup = new ButtonGroup();
    private final JRadioButton easyButton = new JRadioButton("Easy");
    private final JRadioButton mediumButton = new JRadioButton("Medium");
    private final JRadioButton hardButton = new JRadioButton("Hard");
    private final Timer timer;
    private SudokuEventHandler eventHandler;

    public SudokuFrame() {
        setTitle("Sudoku");
        setBounds(100, 100, 668, 438);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        initializeGrid();
        initializeControls();
        
        timer = new Timer(1000, event -> eventHandler.updateTimer());
        eventHandler = new SudokuEventHandler(grid, timerLabel, timer, startButton, submitButton, difficultyGroup, easyButton, mediumButton, hardButton);
        
        attachListeners();
    }

    //Create Sudoku Grid Frame
    private void initializeGrid() {
        int h = 12, w = 13, hi = 39, wi = 37;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) w += 13;
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) h += 11;

                grid[i][j] = new JTextField();
                grid[i][j].setColumns(10);
                grid[i][j].setBounds(h, w, 38, 37);
                grid[i][j].setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
                grid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                grid[i][j].setEditable(false);
                getContentPane().add(grid[i][j]);
                h += hi;
            }
            h = 12;
            w += wi;
        }
    }

    //Create options and buttons
    private void initializeControls() {
        timerLabel.setFont(new Font("Calibri Light", Font.BOLD, 16));
        timerLabel.setBounds(435, 20, 176, 16);
        timerLabel.setVisible(false);
        getContentPane().add(timerLabel);

        JLabel difficultyLabel = new JLabel("Select difficulty:");
        difficultyLabel.setFont(new Font("Calibri Light", Font.BOLD, 16));
        difficultyLabel.setBounds(435, 50, 155, 24);
        getContentPane().add(difficultyLabel);

        easyButton.setFont(new Font("Calibri Light", Font.BOLD, 13));
        mediumButton.setFont(new Font("Calibri Light", Font.BOLD, 13));
        hardButton.setFont(new Font("Calibri Light", Font.BOLD, 13));

        easyButton.setBounds(435, 83, 127, 25);
        mediumButton.setBounds(435, 113, 127, 25);
        hardButton.setBounds(435, 143, 127, 25);

        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);
        difficultyGroup.setSelected(mediumButton.getModel(), true);

        getContentPane().add(easyButton);
        getContentPane().add(mediumButton);
        getContentPane().add(hardButton);

        startButton.setFont(new Font("Calibri Light", Font.BOLD, 18));
        startButton.setBounds(435, 183, 155, 35);
        getContentPane().add(startButton);

        submitButton.setFont(new Font("Calibri Light", Font.BOLD, 18));
        submitButton.setBounds(435, 228, 155, 35);
        submitButton.setVisible(false);
        getContentPane().add(submitButton);
    }

    private void attachListeners() {
        startButton.addActionListener(event -> eventHandler.handleStart());
        submitButton.addActionListener(event -> eventHandler.handleSubmit());
    }
}