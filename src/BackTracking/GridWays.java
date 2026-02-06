package BackTracking;

public class GridWays {

    // Exponential time complexity that is 0(2^n)
    public static int gridWays(int i , int j, int m, int n  ){
        // base
        if(i == m-1 && j == n-1){
            return 1;
        }else if(i == m || j ==n){
                return 0;
        }
        // computer total ways for right steps
        int w1 = gridWays( i , j+1 , m , n);
        int w2 = gridWays( i+1 , j , m , n);
        return w1+w2;
    }

    public static void main(String [] args){
        int n = 3, m = 3;
        System.out.print(gridWays(0,0,m,n ));

    }
}
