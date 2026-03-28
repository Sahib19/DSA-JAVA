package Revision;

public class revision {
    public static void main(String[] args) {
        int arr[] = {1, -2, 6, -1, 3};
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(max < sum){
                max =sum ;
            }
            if(sum <= 0 ){
                sum = 0 ;
            }
        }
        System.out.println(max);
    }
}
