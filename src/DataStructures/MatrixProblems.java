package DataStructures;

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

    public static int diagonalSum(int [][] matrix){
        int sum =0 ;

        // o(n2) approach
//        for(int i= 0 ; i< matrix.length ; i++){
//            for(int j = 0 ; j<matrix[0].length ; j++){
//                if(i==j){
//                    sum += matrix[i][j];
//                }else if(i+j == matrix.length-1){
//                    sum += matrix[i][j];
//                }
//            }
//        }


    // O(n) approach
        for(int i =0 ; i< matrix.length ; i++){
            sum += matrix[i][i];
            if(i != matrix.length-1-i){
                sum += matrix[i][ matrix.length-1-i];
            }
        }

        return sum;
    }

    public static void searchInSortedMatrix(int [][] matrix , int key){
        int row = 0 ;
        int col = matrix[0].length -1 ;
        while(row < matrix.length && col >=0) {
            if (matrix[row][col] == key) {
                System.out.println("Element found at index "+row+" "+col);
                return;
            }
            if (key > matrix[row][col]) {
                row++;
            } else if (key < matrix[row][col]) {
                col--;
            }
        }
        System.out.println("Element not found");
    }

    public static void main (String[]args){
        int [][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
//        printSpiralMatrix(matrix);
//        System.out.println("The diagonal sum is "+diagonalSum(matrix));
    searchInSortedMatrix(matrix , 1);
    }

}
