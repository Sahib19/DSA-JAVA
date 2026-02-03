package DivideAndConqueror;

class MajorityElementDivideConqueror{
   public static int majorityElement(int arr[] , int si , int ei){
       if(si == ei){
           return arr[si];
       }

       int mid = si+(ei-si)/2;

       int leftMajor = majorityElement(arr,si,mid);
       int rightMajor = majorityElement(arr,mid+1,ei);

       if(leftMajor == rightMajor){
           return leftMajor;
       }

       int leftCount = CountInRange(arr , si , ei ,leftMajor);
       int rightCount = CountInRange(arr , si , ei ,rightMajor);

       //Length of current subarray:
       int len = (ei - si + 1) / 2;
       if( leftCount > len){
           return leftMajor;
       } else if (rightCount > len) {
           return rightMajor;
       }else{
           return -1 ; // no major element
       }
   }

   public static int CountInRange(int [] arr ,int si , int ei , int target){
       int count = 0 ;
       for ( int i = si ; i <=ei ; i++){
           if( arr[i] == target){
               count++;
           }
       }
       return count;
   }
}

public class ProblemSheet {


    public static void printArr(String[] arr) {
        for( String el : arr){
            System.out.print(el +" " );
        }
    }
    public static void mergerStringArray(String [] arr , int si , int ei){
        if(si >= ei){
            return;
        }
        int mid = si+ (ei-si)/2;
        mergerStringArray(arr, si ,mid);
        mergerStringArray(arr,mid+1,ei);
        partitionArray(arr, si , mid , ei);
    }
    public static void partitionArray(String [] arr, int si , int mid , int ei){
        String [] temp = new String [ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0 ;

        while(i <= mid && j <= ei){
            if(arr[i].compareTo(arr[j]) <= 0){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for leftover left array
        while( i<= mid){
            temp[k++] = arr[i++];
        }
        // for leftover right array
        while( j <= ei){
            temp[k++] = arr[j++];
        }

        // copying to main original array form temp array
        for(k=0 , i =si ; k<temp.length ; k++ ,  i++){
            arr[i] = temp[k];
        }
    }
    // Majority element Problem
    //brute force approach
   /* public static void majorityElement(int [] arr){
        int [] temp = new int [arr.length+1]; // because 0 bhi consider krna hai
        for (int k : arr) {
            temp[k]++;
        }
        boolean found = false;
        for ( int j =0 ; j < temp.length ; j++){
                if(temp[j] > arr.length/2){
                    System.out.println(j+" is majority");
                    found = true ;
                    break;

                }
        }
        if(!found){
            System.out.println("No Majority element present");
        }
    } */

    public static void MajorityElement(int [] arr){
        for(int el : arr){
            int freq = 0 ;
            for(int val : arr){
                if(el == val ){
                    freq++;
                }
            }
            if(freq> (arr.length)/2){
                System.out.println("Majority element is "+el);
                return;
            }
        }
    }

    // most optimized approach - Moore voting algorithm

    public static int mooreVotingAlgorithm(int [] arr ){
        int frq = 0  , ans = 0 ;

        for (int j : arr) {
            if (frq == 0) {
                ans = j;
            }

            if (ans == j) {
                frq++;
            } else {
                frq--;
            }
        }

        int count = 0;
        for(int val : arr){
            if(val == ans){
                count++;
            }
        }

        if (count > arr.length/2)  return ans;
        else return -1 ;
    }

    // Majority element using recursion + merge sort
    // Pair sum problem
     // Brute force approach
    public static void pairSum(int[] arr ,  int target){
        for(int i =0 ; i< arr.length ; i++){
            for (int j=i+1 ; j< arr.length ; j++){
                if(arr[i]+arr[j] == target){
                    System.out.println(arr[i]+" + "+arr[j]+" Make "+target);
                    return;
                }
            }
        }
        System.out.println("No such pair exist");
    }

    //Optimal approch
    public static void Pairsum( int [] arr , int target){
        int i = 0 , j=arr.length-1 ;
        while(i<j){
            if(arr[i]+arr[j] < target){
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            }else{
                System.out.println(arr[i]+" + "+arr[j]+" Make "+target);
                return;
            }
        }

    }

    public static void main(String[] args){
        int [] arr = {1,2,3,2,2,2,3,3,3,3,3,3};
     MajorityElementDivideConqueror md = new MajorityElementDivideConqueror();
        System.out.println(md.majorityElement(arr, 0 , arr.length-1));
    }
}


