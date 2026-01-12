package DataStructures;

public class search {
    //time complexity = O(n) -> linear increase with the input size
    public static int linearSearch(int array[] , int element){
        for(int i =0 ; i < array.length ; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1 ;
    }

    public static void ReverseArray(int array[]){
        int start = 0 , end = array.length-1;
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static int  BinarySearch(int arr[] , int key){
        int start =0 , end = arr.length-1 ;

        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                end = mid -1 ;
            }else{
                start = mid+1;
            }
        }
        return -1 ;
    }
    public static void main(String[] args){
        int [] marks  = {1,45,65,34,97} ;
//        int result = linearSearch(marks,97);
//        if(result == -1){
//            System.out.println("Element not present in the array");
//        }else{
//            System.out.println("Element found at index "+result);
//        }
        int array [] = {6, 34, 34, 35, 44, 44, 64, 67, 77, 97};
//        ReverseArray(array);
//        for(int i =0 ; i <array.length ; i++) {
//            System.out.print(array[i]);
//        }
        System.out.println("element found at index "+BinarySearch(array,34));
    }
}
