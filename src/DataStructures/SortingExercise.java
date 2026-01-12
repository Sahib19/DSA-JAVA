package DataStructures;

public class SortingExercise {
    public static void printArr(int [] arr){
        System.out.println("The array after sorting is -->");
        for(int p :arr){
                System.out.print(p + ",");
        }
        System.out.println();
    }
    public static void bubbleSort(int [] arr){
        // 1. --> bubble sort
        System.out.println("Bubble Sort");
        for(int i = 0 ; i <= arr.length-2 ; i++){
            int swap =0 ;
            for(int j =0 ; j<= arr.length-2 - i ; j++){
                if(arr[j] > arr[j+1]){
                    // then swap them
                    int temp  = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                System.out.println("loop broke after "+i);
                break;
            }
        }
    }

    public static void selectionSort(int [] arr){
        // 2. --> Selection sort - array me se minimum element ko dhundo aur first me daal do
        System.out.println("Selection Sort");
        for(int i =0 ; i<= arr.length-2 ; i++){
            int min = i ;
            for(int j = i+1 ; j <= arr.length-1 ; j++ ){
                if(arr[min] > arr[j]){// agar min bada huya to swap krdo
                    min = j ;
                }
            }
            // swaping
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp ;

        }
    }
    public static void insertionSort(int [] arr){
        System.out.println("Insertion sort");
        for(int i =1 ; i< arr.length ; i++){
           int curr = arr[i] ;
           int prev = i-1;

            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // swaping
            arr[prev+1] = curr;
        }
    }

    public static void countSort(int [] arr){
        System.out.println("Count sort");

        if (arr.length == 0 ) return ;

        // find the range for the array creation
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i< arr.length ; i++){
            max = Math.max(max , arr[i]) ;
        }
//        System.out.println(max);

        // the frequency array creation
        int [] countArr = new int [max+1] ;

        // filling the count arr
        for(int i = 0 ; i< arr.length ; i++){
            countArr[arr[i]]++;
        }

        // final getting the sorted array
        int j = 0 ;
        for(int i = 0 ; i< countArr.length ; i++){
            while(countArr[i] > 0 ){
                arr[j] = i;
                j++;
                countArr[i]--;
            }
        }
    }
    public static void main(String[] args){
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        int arr2[] = {3,6,2,1,8,7,4,5,3,1};
        int arr3[] = {3,6,2,1,8,7,4,5,3,1};
        int arr4[] = {3,6,2,1,8,7,4,5,3,1};
        bubbleSort(arr);
        printArr(arr);
        selectionSort(arr2);
        printArr(arr2);
        insertionSort(arr3);
        printArr(arr3);
        countSort(arr4);
        printArr(arr4);


    }
}
