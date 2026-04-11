package Revision;

public class Revision2 {
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean nQueens(int row, char[][] board) {
        if (row == board.length) {
            System.out.println("------ Chess Board ------");
            printBoard(board);
            return true;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
               if( nQueens(row + 1, board)) return true ;
                board[row][i] = 'X';

            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        //left diagonal
        for( int i = row -1 , j = col -1 ; i >= 0 && j >= 0 ; i-- , j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // top diagonal
        for( int i = row -1 ; i >= 0 ; i--){
            if(board [i][ col] == 'Q'){
                return false;
            }
        }

        // right diagonla -> col++ row--
        for( int i = row-1 , j= col+1 ; i >= 0 && j < board[0].length ; j++,i--){
            if( board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'}};

        nQueens(0 , board);
    }
}
