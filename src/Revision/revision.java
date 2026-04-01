package Revision;
import java.util.Arrays;

public class revision {
    public static void main(String[] args) {
        // Sorting algorithm revision
        int [] arr = {4,5,3,2,6,7,8,4,7,4};
        int max = Integer.MIN_VALUE;
        for( int ele : arr){
            if(max < ele ){
                max = ele ;
            }
        }

        int auxArr [] = new int [max+1];

        for (int k : arr) {
            auxArr[k]++;
        }
    int a = 0 ;
        for( int i = 0 ; i < auxArr.length ; i++){
            while(auxArr[i] > 0 ){
                arr[a] = i ;
                auxArr[i]--;
                a++;
            }
        }

        for (int j : arr) System.out.print(j + " ");
    }
}
