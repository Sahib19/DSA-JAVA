package BackTracking;

public class Problems {
    // 1. Rat in a Maze Problem
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
    public static void main(String [] args){
    /*     0 -> raa blocked aa  | 1 -> chuhha nikal sakda etho
        int [][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        String path = "";
        ratInMazeProblem(maze,0,0,path);

     */
    String [] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    String str = "";
    keypadCombinationProblem(arr,str,"",0);
    }
}
