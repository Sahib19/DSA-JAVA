package ArrayList;
import java.util.*;

public class ProblemSheet {
    public static void printArray(int [] arr){
        for(int i=0 ; i< arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

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


    // Problem 2 - Approach 1 -> brute force - O(n^2) time complexity

//    public static int [] lonelyNumber(int [] arr){
//        int [] lonelyArr = new int [arr.length];
//        int idx =0 ;
//        for( int i = 0 ; i < arr.length ; i++){
//            int count = 0 ;
//            boolean isBhai = false;
//            for ( int j =  0 ; j< arr.length  ; j++){
//                if(arr[i] == arr[j]){
//                    count++;
//                }
//                if(arr[j] == arr[i]-1 || arr[j] == arr[i]+1){
//                    // it mean vo lonely number nhi hai
//                    isBhai = true ;
//                }
//            }
//            if(!(isBhai) && count < 2){
//                lonelyArr[idx++] = arr[i];
//            }
//        }
//        return lonelyArr;
//
//    }

    // optimized approach-> sorted array approach
//    public static ArrayList<Integer> Lonelynumber(int [] arr){
//        ArrayList<Integer> lonelyEleList = new ArrayList<>();
//        Arrays.sort(arr); // sort array in O(n log n ) time complexity
//
//        for( int i =1 ; i < arr.length -1 ; i++){
//            if(arr[i-1]+1 < arr[i] && arr[i+1]-1 > arr[i]){
//                // ye lonely element hai
//                lonelyEleList.add(arr[i]);
//            }
//        }
//
//        // IF size of array list is 1 -> then above loop will not execute single time
//        if(arr.length == 1 ){
//            lonelyEleList.add(arr[0]);
//        }
//        if(arr.length > 1){
//            // for first element as it is not considered in loop
//            if(arr[1] - 1 > arr[0]){
//                lonelyEleList.add(arr[0]);
//            }
//
//            // for last element as it is not considered in loop
//            if(arr[arr.length-2]+1 < arr[arr.length-1]){
//                lonelyEleList.add(arr[arr.length-1]);
//            }
//        }
//
//        return lonelyEleList ;
//    }

    // more cleaner lonely number code
//    public static ArrayList<Integer> lonelyNumber(int[] arr) {
//        ArrayList<Integer> result = new ArrayList<>();
//        Arrays.sort(arr);
//        int n = arr.length;
//
//        if (n == 1) {
//            result.add(arr[0]);
//            return result;
//        }
//
//        for (int i = 0; i < n; i++) {
//
//            boolean leftOk = (i == 0) || (arr[i] - arr[i - 1] > 1);
//            boolean rightOk = (i == n - 1) || (arr[i + 1] - arr[i] > 1);
//
//            if (leftOk && rightOk) {
//                result.add(arr[i]);
//            }
//        }
//
//        return result;
//    }

    //Most frequent number in an array
    public static int mostFrequent(int[] nums, int key) {
        int maxCount = 0 ;
        int result = -1 ;

        int [] freq = new int [1001]; // we can only accept values where 0 <= nums[i] <= 1000

        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] == key){
                int target = nums[i+1];
                freq[target]++;

                if(freq[target] > maxCount){
                    maxCount = freq[target];
                    result = target ;
                }
            }
        }
        return result;

    }

    public static ArrayList <Integer> beautifulArray(int n){
        ArrayList <Integer> list = new ArrayList <>();
        list.add(1);

        while(list.size() < n){
            ArrayList <Integer> temp = new ArrayList <>();

            //finding all odd and pushing it in list
            for(int x : list){
                int odd = 2*x-1;
                if(odd <= n){
                    temp.add(odd);
                }
            }

            //finding all odd and pushing it in list
            for(int x : list){
                int even = 2*x;
                if(even <= n){
                    temp.add(even);
                }
            }

            list = temp ;
        }

        return list;
    }


    public static void main(String[] args){
//        ArrayList <Integer> nums =new ArrayList<>(Arrays.asList(5,5,4,3,2,1));
//        System.out.println(isMonotonic(nums));

//        int [] arr = {1,3,5,3};
//        ArrayList<Integer> resultArr = Lonelynumber(arr);
//        System.out.print(resultArr);

//        int [] nums = {1,100,3,4,1,6,1,100,3};
//        System.out.print(mostFrequent(nums,1));

        System.out.print(beautifulArray(6));



    }
}
