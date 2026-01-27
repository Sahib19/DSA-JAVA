package DivideAndConqueror;

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

    public static void majorityElement(int [] arr){
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
    }
    public static void main(String[] args){
        int [] arr = {1,1,2,2,3,3,3,3};
        majorityElement(arr);
    }
}
