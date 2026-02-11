package ArrayList;
import java.util.*;

public class arrayList {

    public static void Swap(ArrayList<Integer> list ,  int idx1 , int idx2){
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
    }

    //Time complexity -> O(n)
    public static int containerWithMostWater(ArrayList<Integer> list){
    int leftPointer = 0 ;
    int rightPointer = list.size()-1;
    int maxWater = Integer.MIN_VALUE;
    while(leftPointer < rightPointer){
        int width = rightPointer - leftPointer ;
        int height = Math.min(list.get(leftPointer) , list.get(rightPointer));
        int currentWater = width*height;
        maxWater = Math.max(maxWater , currentWater);

        if(list.get(leftPointer) < list.get(rightPointer) ){
            leftPointer++;
        }else{
            rightPointer--;
        }
    }
        return maxWater;
    }

    // time complexity -> O(n)
    public static void pairSum1(int [] arr , int target){
    //the arr is sorted
        int lp = 0;
        int rp = arr.length-1;

        while (lp < rp ){ // lp != rp
            if(arr[lp]+arr[rp] == target){
                System.out.print("Index are "+lp+" and "+rp);
                break;
            }else if(arr[lp]+arr[rp] < target){
                lp++;
            }else{
                rp--;
            }
        }
    }

    // here the array is rotated and sorted
    public static void pairSum2(int [] arr , int target){
        int n = arr.length;
        if ( n < 2 ) return;

        boolean isRotated= false;
        int lp = 0, rp = 0 ;
        // first we find the breaking point
        for(int i = 0 ; i< n-1 ; i++){
            if(arr[i] > arr[i+1]){
                lp = i+1 ;
                rp = i ;
                isRotated = true;
                break;
            }
        }
        // in case array is not rotated
        if(!isRotated){
            rp = n-1;
        }

        //the arr is sorted adn rotated form pivot element
        while (lp != rp ){ // lp != rp
            if(arr[lp]+arr[rp] == target){
                System.out.print("Index are "+lp+" and "+rp);
                break;
            }else if(arr[lp]+arr[rp] < target){
                lp =  (lp+1)%n; // last se 0 par ayega
            }else{
                rp = (n+rp-1)%n; // 0 to last tak jaeyga
            }
        }

    }
    public static void main(String [] args) {
//        int max =Integer.MAX_VALUE;
//        for(int i =0 ;  i< list.size() ; i++){
//            System.out.print(list.get(i)+" ");
//        }
//        Swap(list,2,4);
        ArrayList <Integer> list = new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
//        System.out.println(containerWithMostWater(list));

        //pairSum
        int [] arr = {3,2,4};
//        pairSum1(arr,15);

        // pairSum-2
        int [ ] arr2 = {11,15,6,8,9,10};
        pairSum2(arr2,26);

    }
}
