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

    public static void ratMat(int[][] maze , int row , int col , String path){
        if(row == maze.length-1 && col == maze[0].length-1){
            // solution tak pauch gaye ham
            System.out.println(path+"( "+row+","+col+" )");
            return;
        }
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length){
            // cancel this solution
            return;
        }
        if(maze[row][col] == 0){
            return;
        }

        maze[row][col] = 0;

        ratMat(maze,row,col+1 , path+"( "+row+","+col+" )");
        ratMat(maze,row+1,col ,path+"( "+row+","+col+" )");
        ratMat(maze,row-1,col ,path+"( "+row+","+col+" )");
        ratMat(maze,row,col-1 ,path+"( "+row+","+col+" )");

        maze[row][col] = 1;

    }


    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        ratMat(maze,0,0,"");
    }
}
