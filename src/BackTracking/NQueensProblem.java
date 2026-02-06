package BackTracking;

public class NQueensProblem {
    public static void PrintBoard(char[][] board){
        for(int row =0 ; row < board.length ; row++){
            for(int col = 0 ;  col < board[0].length ; col++){
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board , int row , int col){
        //left up diagonal
        for(int i = row-1 , j = col-1 ; i >=0 && j>=0 ; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // same column (upwards)
        for(int i = row-1 ; i >= 0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // right up diagonal
        for(int i = row-1 , j= col+1 ; i >=0  && j < board.length ; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void NQueens(char[][] board , int row){
        if(row == board.length){
            System.out.println("----Chessboard----");
            PrintBoard(board);
            return;
        }
        for(int i =0 ; i<board.length ; i++){
            if(isSafe(board ,row , i )){
                board[row][i] = 'Q';
                NQueens( board , row+1);
                board[row][i] = 'X';
            }
        }
    }
    public static void main(String[] args){
        int n = 4 ;
        char [][] board = new char[n][n];

        // Initialization of Board
        for(int row =0 ; row < board.length ; row++){
            for(int col = 0 ;  col < board[0].length ; col++){
                board[row][col] = 'X';
            }
        }

        //Calling NQueens
        NQueens(board,0);

    }
}
