package Revision;
import java.util.*;

public class LeetCode {

    public static void arrayPermutation( int [] arr , int idx){

        if( idx == arr.length-1){
            System.out.println(Arrays.toString(arr) + " ");
            return;
        }
//        idx => current walla
        for( int i = idx ; i < arr.length ; i++){
            int temp = arr[i];
            arr[i] = arr [idx];
            arr[idx] = temp;

            arrayPermutation(arr , idx+1);

            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp ;
        }
    }
    public static void main (String [] args){
        int [] arr = {1,2,3};
        arrayPermutation(arr,0);


    }
}
