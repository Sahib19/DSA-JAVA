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

    public static void quickSort(int[]  arr, int si , int ei){
        if(si>= ei ){
            return;
        }

        int pIdx = partition(arr,si,ei);
        quickSort(arr,si,pIdx-1); // left
        quickSort(arr,pIdx+1,ei); // right
    }

    public static int partition(int [] arr, int si , int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j = si ; j < ei ; j++){
            if(arr[j] <=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // place pivot at correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        return i;
    }

    public static void main(String[] args){
        int[] arr = {1,5,9,3,4,-2};
        quickSort(arr, 0 , arr.length-1);
        printarr(arr);
    }


}
