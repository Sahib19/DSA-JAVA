package Revision;


public class Revision2 {
    public static void printBoard(int [][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean SudokuSolver( int [][] sudo , int row , int col){
        if(row == 9 ) {
            printBoard(sudo);
            return true;
        }


        int nextRow = row, nextCol =  col+1;
        if( nextCol == 9){
            nextRow = row+1;
            nextCol = 0 ;
        }
         if(sudo[row][col] != 0 ){
             return SudokuSolver(sudo, nextRow , nextCol);
         }

        for( int digit  = 1 ; digit <= 9 ; digit++){
            if( isSafe(sudo , row , col , digit)){
                sudo[row][col] = digit;
                if(SudokuSolver(sudo,nextRow , nextCol)){
                    return true;
                };
                sudo[row][col] = 0 ;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][]sudo , int row , int col , int digit){
        // column wise
        for( int i  = 0 ; i < 9  ; i++ ){
            if(sudo[i][col] == digit) return false;
        }

        // row wise
        for( int i  = 0 ; i < 9  ; i++ ){
            if(sudo[row][i] == digit) return false;
        }

        //grid chek
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for( int i = sr ; i < sr+3 ; i++){
            for( int j = sc  ; j < sc+3 ; j++){
                if(sudo[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int [][] sudo = {
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},
                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},
                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        SudokuSolver(sudo,0,0);
    }
}
