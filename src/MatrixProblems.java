public class MatrixProblems {
    public static void printSpiralMatrix(int[][] matrix){
      int startRow = 0;
      int startCol = 0;
      int endRow = matrix.length -1 ;
      int endCol = matrix[0].length -1 ;

      while (startRow <= endRow && startCol <= endCol) {
          // printing top row
          for (int j = startCol; j <= endCol; j++) {
              System.out.print(matrix[startRow][j] + " ");
          }
          // printing right column
          for (int q = startRow + 1; q <= endRow; q++) {
              System.out.print(matrix[q][endCol] + " ");
          }
          //printing bottom row - end row constant
          for (int a = endCol - 1; a >= startCol; a--) {
              if(startRow == endRow) break ;
              System.out.print(matrix[endRow][a] + " ");
          }

          // printing left column - start col constant
          for (int l = endRow - 1; l >= startRow + 1; l--) {
              if (startCol == endCol ) break ;
              System.out.print(matrix[l][startCol] + " ");
          }

          startRow++;
          startCol++;
          endCol--;
          endRow--;
      }

    }
    public static void main (String[]args){
        int [][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printSpiralMatrix(matrix);
    }
}
