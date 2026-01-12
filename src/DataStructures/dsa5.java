package DataStructures;

public class dsa5 {
    // Code to print all subarray
    public static void Subarray(int [] MainArray){
        for(int i =0 ; i<MainArray.length ; i++){
            for(int j = i ; j<MainArray.length ; j++ ){
                for(int k = i ; k<=j ; k++){
                    System.out.print(MainArray[k]);
                }
                System.out.println("-");
            }
            System.out.println();
        }
    }

    public static boolean p1(int [] arr){
        for(int i = 0 ; i<arr.length ; i++){
            for(int j=i+1 ; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
      int [] array = {2,5,6,7,8,8};
//        Subarray(array);
        System.out.println(p1(array));;

    }
}
