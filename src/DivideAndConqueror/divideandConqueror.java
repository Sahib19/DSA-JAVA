package DivideAndConqueror;

public class divideandConqueror {
    public static void printarr(int[] arr) {
        for( int el : arr){
            System.out.print(el +" " );
        }
    }
    public static void mergeSort(int [] arr, int si , int ei){
        if(si >= ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int [] arr ,int si ,int mid ,int ei){
        int [] temp = new int [ei-si+1]; // is ke karn hi space complexity O(n)
        int i = si ;
        int j = mid+1;
        int k = 0 ;

        //filling the temp array made from 2 sorted subarray(left one and another is right one)
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for the left remaining sorted array
        while(i<= mid){
            temp[k++] = arr[i++];
        }
        // for the right remaining sorted array
        while(j<= ei){
            temp[k++] = arr[j++];
        }

        //copying of array from temp to main arr
        for( k =0 , i=si ; k < temp.length ; k++ , i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args){
        int[] arr = {1,5,9,3,4};
        mergeSort(arr,0, arr.length-1);
        printarr(arr);
    }


}
