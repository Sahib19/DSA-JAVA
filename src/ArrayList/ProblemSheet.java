package ArrayList;
import java.util.*;

public class ProblemSheet {

    // ArrayList is Monotonic or not
//    public static boolean isMonotonic(ArrayList<Integer> nums){
//        boolean isIncMonotonic = true;
//        // monotonic increasing
//        for(int i =0 ; i< nums.size()-1 ; i++){
//            if(!(nums.get(i) <= nums.get(i+1))){
//                isIncMonotonic = false;
//                break;
//            }
//        }
//
//        // monotonic decreasing
//        boolean isDecMonotonic = true;
//        for(int i =0 ; i< nums.size()-1 ; i++){
//            if(!(nums.get(i) >= nums.get(i+1))){
//                isDecMonotonic = false;
//                break;
//            }
//        }
//
//        if(isDecMonotonic || isIncMonotonic ){
//            return true;
//        }else{
//        return false;
//        }
//    }

    // single loop approach
    public static boolean isMonotonic(ArrayList<Integer> nums){
        int n = nums.size();
        boolean incMono = true ;
        boolean decMono = true ;
        for( int i = 0 ; i < n-1; i++){
           if( !(nums.get(i) <= nums.get(i+1))){
               incMono =false;
           }
           if(!(nums.get(n-1-i) <= nums.get(n-2-i))) {
               decMono =false;
           }
        }
        return incMono || decMono;
    }
    public static void main(String[] args){
        ArrayList <Integer> nums =new ArrayList<>(Arrays.asList(5,5,4,3,2,1));
        System.out.println(isMonotonic(nums));

    }
}
