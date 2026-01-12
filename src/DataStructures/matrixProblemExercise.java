package DataStructures;

public class matrixProblemExercise {
    // Print the number of 7’s that are in the 2d array.
    public static void printNoOf7(int [][] matrix ){
        int count = 0;
//        for (int[] ints : matrix){
        for(int row = 0 ; row < matrix.length ; row++){
            for(int col =  0 ; col < matrix[0].length ; col++){
                if(matrix[row][col] == 7)
                    count++;
            }
        }

        System.out.println("The number of seven present are "+count);
    }

    // second row ka sum
    public static void sum(int [][] matrix){
        int sum = 0 ;
        int row = 1 ;
        int col =0 ;
        while (col <= matrix[0].length-1){
            sum += matrix[row][col];
            col++;
        }

        System.out.println("The sum of second row is "+sum);
    }

    // transpose of a matrix
    public static void transpose(int [][] matrix){
        for(int col = 0 ; col < matrix[0].length ; col++){
            for(int row = 0 ; row < matrix.length ; row++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int [] [] matrix = {{12,4,65,7},{22,7,7,7},{1,65,8,9},{34,67,55,99}};
        int  [] [] nums = { {1,4,9},{11,4,3},{2,2,3} };
//        printNoOf7(matrix);
//        sum(nums);
        int [] [] matrix2 = {{1,4,5,7},{2,7,7,7},{1,6,8,9}};
    transpose(matrix2);
    }

}
