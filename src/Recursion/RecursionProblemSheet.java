package Recursion;

public class RecursionProblemSheet {
    public static void PrintAllOccurrences(int idx , int[] arr , int key){
        if(idx == arr.length){
            return;
        }
        if(arr[idx] == key){
            System.out.print(idx+" ");
        }

        PrintAllOccurrences(idx+1 ,arr,key );
    }

    public static void NumberToWord(int idx ,String num , String[] arr){
        if(idx == num.length()){
            return;
        }
        int index = Integer.parseInt(String.valueOf(num.charAt(idx)));
        System.out.print(arr[index]+" ");
        NumberToWord(idx+1 , num , arr);
    }

    public static void numbertoword(int num , String[] arr){
        if(num == 0){
            return;
        }
        int index = num%10;
        numbertoword(num/10,arr);
        System.out.print(arr[index]+" ");
    }

    public static int stringLength(String str , int n , int count){
        if(n==str.length()){
            return count ;
        }
        return stringLength(str , n+1 ,++count);
    }

    public static int StringLength(String str){
        if(str.isEmpty()){
            return 0;
        }
//        if(str.equals("")){
//            return 0;
//        }
        return 1 + StringLength(str.substring(1));
    }

    public static void subarray(String str){
        for(int i =0 ; i< str.length() ; i++){
            for(int j =i ; j< str.length() ; j++){
                    for (int k = i; k <= j; k++) {
                        System.out.print(str.charAt(k) + " ");
                    }
                System.out.println();
            }
        }
    }

    public static void Substrings(int idx1, String str , String subs){
        if(idx1 == str.length()){
            System.out.print(subs);
            return;
        }
        subs += subs.charAt(idx1);
        System.out.print(subs+" ");
        Substrings(idx1+1 , str , subs);

    }

    public static void towerOfHanoi(int n , String src,String helper , String destination){
        if(n==1){
            System.out.println("Transfer disk from "+ src +" to "+ destination );
            return;
        }
        towerOfHanoi(n-1,src,destination,helper);
        System.out.println("Transfer disk from "+ src +" to "+ destination );
        towerOfHanoi(n-1,helper,src,destination);
    }

    public static void main(String [] args){
/*        String [] arr = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
//        NumberToWord(0,"2010" , arr);
//        System.out.println();
*/
    towerOfHanoi(3,"S","H","D");
    }
}
