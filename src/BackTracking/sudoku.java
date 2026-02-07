package BackTracking;

public class sudoku {
    public static void printSudoku( int [] [] Sudoku){
        for(int row =0 ; row < Sudoku.length ; row++){
            for( int col = 0 ; col < Sudoku[0].length ;col++){
                System.out.print(Sudoku[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int [] [ ] Sudoku , int row , int col , int digit){
    //here we check whether safe to place that digit or not

        // checking within its column
        for(int i = 0 ; i<9 ; i++ ){
            if(Sudoku[i][col] == digit){
                return false;
            }
        }

        //checking with in its row
        for( int j =0 ; j< 9 ; j++){
            if(Sudoku[row][j] == digit){
                    return false;
            }
        }

        //calculating starting row (SR) and starting column (SC);
        int SR = (row/3)*3;
        int SC = (col/3)*3;

        for(int m = SR ; m < SR+3 ; m++){
            for ( int n = SC ; n < SC+3 ; n++){
                if(Sudoku[m][n] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int [][] Sudoku , int row , int col){
        // base case
        if(row == 9){
            return true ;
        }

        // Main recursion Concept

        //Setting the values of nextRow and nextColumn variables
        int nextRow = row ,  nextColumn = col+1;
        if(nextColumn == 9){
            nextRow = row+1;
            nextColumn = 0;
        }

        if(Sudoku[row][col] != 0){
            return sudokuSolver(Sudoku , nextRow , nextColumn);
        }

        for(int digit =1 ; digit <=9 ; digit ++){
            if(isSafe(Sudoku , row , col , digit)){
                Sudoku[row][col] = digit ;
              if( sudokuSolver(Sudoku , nextRow , nextColumn)){
                  return true;
              }
                Sudoku[row][col] = 0 ;
            }
        }

        return false ;
    }
    public static void main(String [] args) {
        int [][] sudoku = {
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

        int[][] sudoku2 = {
                {5, 5, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };


        if(sudokuSolver(sudoku2 , 0 , 0)){
            System.out.println("Solution exist");
            printSudoku(sudoku2);
        }else{
           System.out.println("No Solution exist for your Sudoku");
        }

    }

}
