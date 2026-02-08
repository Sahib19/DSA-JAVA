package BackTracking;


public class Problems {
    //Printing Array
    public static void printArr(int [][] arr){
        for(int i =0 ; i< arr.length ; i++){
            for( int j = 0 ; j< arr[0].length ; j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }

    // 1. Rat in a Maze Proble,
    public static void ratInMazeProblem(int [][] maze , int row , int col , String path ){
        // base case
        if(row == maze.length-1 && col == maze.length-1){
            System.out.println(path + "(" + row + "," + col + ") ");
            return;
        }
        if(row == maze.length || row == -1 || col == maze.length || col == -1){
            return ;
        }

        if(maze[row][col] == 0){
            return;
        }

        // 4 calls lagegi for each direction
        // 3️⃣ Mark as visited
        maze[row][col] = 0;

        // 4️⃣ Explore all 4 directions
        ratInMazeProblem(maze, row + 1, col, path + "(" + row + "," + col + ") "); // Down
        ratInMazeProblem(maze, row, col + 1, path + "(" + row + "," + col + ") "); // Right
        ratInMazeProblem(maze, row, col - 1, path + "(" + row + "," + col + ") "); // Left
        ratInMazeProblem(maze, row - 1, col, path + "(" + row + "," + col + ") "); // Up

        // 5️⃣ Backtrack (unmark)
        maze[row][col] = 1;

    }

    // Keypad combination problem
    public static void keypadCombinationProblem(String [] arr ,  String str , String sb , int idx){
        // base case
        if(idx == str.length()){
            System.out.print(sb+" ");
            return;
        }

        // recursion concept
        char num = str.charAt(idx);
        String associatedAlphabet = arr[num - '0']; // ye concept payara hai

        for(int i  = 0 ; i< associatedAlphabet.length() ; i++){
            char ch = associatedAlphabet.charAt(i);
            keypadCombinationProblem(arr,str,sb+ch,idx+1);
        }
    }

    //Knight Problem
    public static boolean KnightProblem(int[][] chess, int row, int col, int num) {

        // Boundary check
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length) {
            return false;
        }

        // Already visited
        if (chess[row][col] != 0) {
            return false;
        }

        // Place current move
        chess[row][col] = num;

        // Base condition (last move placed)
        if (num == chess.length * chess.length) {
            return true;
        }

        // Try all 8 knight moves
        if (KnightProblem(chess, row - 1, col + 2, num + 1) ||
                KnightProblem(chess, row - 1, col - 2, num + 1) ||
                KnightProblem(chess, row + 1, col + 2, num + 1) ||
                KnightProblem(chess, row + 1, col - 2, num + 1) ||
                KnightProblem(chess, row + 2, col + 1, num + 1) ||
                KnightProblem(chess, row + 2, col - 1, num + 1) ||
                KnightProblem(chess, row - 2, col - 1, num + 1) ||
                KnightProblem(chess, row - 2, col + 1, num + 1)) {
            return true;
        }

        // Backtrack
        chess[row][col] = 0;
        return false;
    }

    public static void main(String [] args){
    /*     0 -> raa blocked aa  | 1 -> chuhha nikal sakda etho
        int [][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        String path = "";
        ratInMazeProblem(maze,0,0,path);

     */
//    String [] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//    String str = "";
//    keypadCombinationProblem(arr,str,"",0);

        int[][] chess = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };


        KnightProblem(chess,0,0,1);

        printArr(chess);

    }
}
