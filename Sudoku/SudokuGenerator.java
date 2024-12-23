import java.util.Random;

public class SudokuGenerator {
    private static int board[][] = new int[9][9];
    
    //To make a simple solved puzzle for seed.
    public static void generateSeed(){
        board = SudokuSolver.solve(board);
    }
    
    //To get a new permutation of seed puzzle.
    public static void generatePermutation(int select){
        int s0, s1, min = 0, max = 2;
        Random r = new Random();
        for(int i = 0; i < 3; i++){
            s0 = r.nextInt(max - min + 1) + min;
            do{
                    s1 = r.nextInt(max - min + 1) + min;
            }
            while(s1 == s0);
            max += 3; min += 3;
            if(select == 0) permutationCol(s0, s1);
            else permutationRow(s0, s1);
        }
    }
    
    //To get permutation with 3x3 columns.
    public static void permutationCol(int s0, int s1){
        for(int i = 0; i < 9; i++){
            int temp = board[i][s0];
            board[i][s0] = board[i][s1];
            board[i][s1] = temp;
        }
    }
    
    //To get permutation with 3x3 rows.
    public static void permutationRow(int s0, int s1){
        for(int i = 0; i < 9; i++){
            int temp = board[s0][i];
            board[s0][i] = board[s1][i];
            board[s1][i] = temp;
        }
    }
    
    //To get permutation with 3x9 rows.
    public static void exchangeRows(int s0, int s1){
           for(int i = 0; i < 3; i++)
           {
              for(int j = 0; j < 9; j++)
              {
                 int temp = board[s0][j];
                 board[s0][j] = board[s1][j];
                 board[s1][j] = temp;
              }
              s0++;
              s1++;
           }
    }
    
    //To get permutation with 9x3 columns.
    public static void exchangeCols(int s0, int s1){
           for(int i = 0; i < 3; i++)
           {
              for(int j = 0; j < 9; j++)
              {
                 int temp = board[j][s0];
                 board[j][s0] = board[j][s1];
                 board[j][s1] = temp;
              }
              s0++;
              s1++;
           }
    }
    
    //To transpose the board.
    public static void transpose(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }
    
    //To clear space at (s0, s1)
    public static int clearNum(int s0, int s1)
    {
        int count = 9;
        for(int i = 1; i <= 9; i++){
            if(!SudokuSolver.isMoveValid(s0, s1, i, board)) count--;
            if(count == 1){
                board[s0][s1] = 0;
                return 1;
            }
        }
        return 0;
    }
    
    public static int[][] generate(int difficulty){
        Random r = new Random();
        
        //Number of cell/grid that need an input
        int maxCount;
        if (difficulty == 0){ //easy
            maxCount = 20;
        } else if (difficulty == 2){ //hard
            maxCount = 40;
        } else { //default or medium
            maxCount = 30;
        }
        
        //Reset the old puzzle.
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = 0;
            }
        }
        
        int count = 0, s0, s1;
        int choice[] = {0, 3, 6};
        
        generateSeed();
        if(r.nextInt(2) == 0) transpose();
        generatePermutation(1);
        generatePermutation(0);
        
        
        for(int i = 0; i < 2; i++){
            s0 = choice[r.nextInt(3)];
            do{
                s1 = choice[r.nextInt(3)];
            }while(s0 == s1);
            
            if(i % 2 == 0) exchangeRows(s0, s1);
            else exchangeCols(s0, s1);
        }
        while(count < maxCount){
            s0 = r.nextInt(9);
            s1 = r.nextInt(9);
            count += clearNum(s0, s1);
        }
        return board;
    }
}