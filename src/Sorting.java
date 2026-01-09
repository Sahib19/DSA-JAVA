public class Sorting {
    public static void BubbleSort(int [] array){
        for(int i=0 ; i<= array.length-2 ; i++){
            int swap =0 ;
            for(int j=0 ; j <= array.length-2-i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap ++;
                }
            }
            if(swap==0){
                System.out.println("Array Sorted after "+(i+1)+" iteration");
            return;
            }
//            System.out.println();
//            System.out.println("Array after "+i+" iteration");
//            for(int p = 0 ; p<array.length ; p++){
//                System.out.print(array[p]+" ");
//            }
        }
    }

    public static void selectionSort(int [] arr){
        for ( int i=0 ; i< arr.length-1 ; i++){
            int min = i ;
            for(int j = i+1  ; j<= arr.length-1 ; j++){
                if(arr[min] > arr[j]){
                    min=j;
                }
            }
            //swaping with beginning element of the minimum element
        int temp = arr[min] ;
            arr[min] = arr[i];
            arr[i]= temp;

        }
    }

//    public static void insertionSort(int []arr){
//        for(int i =0 ; i < arr.length-1 ; i++){
//            int tempStorage = arr[i+1];
//            for(int j = i+1 ; j>= 0 ; j-- ){
//                if(j==0){
//                    arr[j] = tempStorage;
//                }
//                else if(tempStorage < arr[j-1]){
//                    arr[j] = arr[j-1];
//                }else{
//                    arr[j] = tempStorage ;
//                }
//            }
//        }
//    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int tempStorage = arr[i + 1];

            for (int j = i + 1; j >= 0; j--) {
                if (j == 0) {
                    arr[j] = tempStorage;
                    break;
                }
                else if (tempStorage < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                }
                else {
                    arr[j] = tempStorage;
                    break;
                }
            }
        }
    }

    public static void insertionSort2(int [] arr){
        for(int i=1 ; i < arr.length ; i++){
            int curr = arr[i] ;
            int prev = (i-1);
            while(prev >=0 && curr < arr[prev]){
                arr[prev+1] = arr[prev];
                prev --;
            }

            // insertion of current element at correct position

            arr[prev+1] = curr;
        }
    }

    public static void main(String[] args){
        int [] array = { 5,3,6,7,3};
//        BubbleSort(array);
//        System.out.println();
//        selectionSort(array);
        insertionSort2(array);
        System.out.println("The sorted array is ");
        for(int p = 0 ; p<array.length ; p++){
            System.out.print(array[p]+" ");
        }

    }
}
