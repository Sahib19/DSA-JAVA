package Revision;

public class Revision2 {

    // this program will give then nth term
//    public static int tiling( int n) { // 2
//
//    }

    public static int pow2( int x , int n){
        int ans = 1 ;
        while(n > 0 ){
            if( (n&1) != 0 ){
                ans = ans *x ;
            }
            x = x*x;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 6};
        System.out.println(pow2(2,10));
    }
}
