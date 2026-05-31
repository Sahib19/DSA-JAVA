package Heap;
import java.util.*;

public class ass {

    public static int fillNSlots(int[] arr , int n) {
//        n -> numbers of slots start from zero
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        for(int ele : arr){
           for( int i = 1 ; i <= n ; i++ ){
               if(ele != i){
                   int minDist = Math.abs(ele-i);
                   pq.add(minDist);
               }
           }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        // Fill n slots


    }
}
