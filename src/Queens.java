public class Queens {
    int[][] gameBoard = new int[8][8];
    int numRows = gameBoard.length;
    int numCols = gameBoard[0].length;

    public boolean solveGame(int startingRow, int startingCol){
        int queenGoal = 8;
        int queenNum = 1;
        gameBoard = new int[8][8];
        gameBoard[startingRow][startingCol] = 1;
        for(int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {

                if(canPlace(row, col)){
                    gameBoard[row][col] = 1;
                    queenNum ++;
                }
                if(queenNum == queenGoal){

                    return true;
                }
            }
        }
        return false;
    }
    public boolean canPlace(int rowi, int coli){
        for(int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if(gameBoard[row][col] == 1){
                    if(canTake(rowi, coli, row, col)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean canTake(int row1, int col1, int row2, int col2){
        return row1 == row2 || col1 == col2 || Math.abs(row1 - row2) == Math.abs(col1 - col2);
    }
     public void print2DArray(){
        for(int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(gameBoard[row][col] + ", ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Queens queens = new Queens();
        for(int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(queens.solveGame(row, col)){
                    queens.print2DArray();
                    System.out.print("solution");
                    System.out.println();
                }
            }
        }
    }
}
