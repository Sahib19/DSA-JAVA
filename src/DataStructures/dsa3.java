package DataStructures;

public class dsa3 {
    public static void Pairing(int arr[]){
        for(int i =0 ; i <arr.length ; i++){
            for(int j = i+1 ; j< arr.length ; j++){
                System.out.print("( "+ arr[i] +" , "+arr[j]+" )");
            }
            System.out.println();
        }
    }

    // Max subarray sum ka bhi niche hi code likh diya hu iske sath hi
    public static void subArray(int array[]){

        for (int  i = 0 ; i <array.length ; i++ ){
            int Max_Sum = Integer.MIN_VALUE ;
            for (int j = i ; j<array.length ; j++){
                int sum = 0 ;
                    for(int k = i ; k<= j ; k++){
                        System.out.print(array[k]+" ");
                        sum = sum + array[k];

                    }
                System.out.println(" - "+sum);
                if(Max_Sum < sum){
                    Max_Sum = sum ;
                }
            }
            System.out.println("Among all sum the maximum sum is "+Max_Sum);
            System.out.println();
        }

    }
    public static void PrefixSumMaxSumSubarray(int arr[]){
        // calculating prefix array
        int[] prefixArr  = new int[arr.length];
        int MAX_SUM = Integer.MIN_VALUE ;
        int sum;
         prefixArr[0] = arr[0];
        for(int p = 1 ; p<arr.length ;p++){
            prefixArr[p] = prefixArr[p-1]+arr[p] ;
        }

        for(int i =0 ; i <arr.length ; i++){
            for(int j = i ; j<arr.length ; j++){
                sum = i == 0 ? prefixArr[j] :  prefixArr[j] - prefixArr[i-1];
                if(MAX_SUM < sum){
                    MAX_SUM = sum ;
                }
            }
        }
        System.out.println("Max sum is "+MAX_SUM);
    }

    public static void Kadane(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0 ;
        for(int i = 0 ;  i<arr.length ; i++){
            currentSum = currentSum+arr[i];
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
            if(currentSum <0 ){
                currentSum = 0;
            }
        }
        System.out.println("The Max Subarray sum is "+maxSum);
    }

    public static void main (String[] args){
        int arr1 [] = {2,4,6,8,10};
//        Pairing(arr1);
    subArray(arr1);
//    PrefixSumMaxSumSubarray(arr1);
//        int arr2 [] = {-2,-3-2,-5,-3};
//        Kadane(arr2);
    }
}
