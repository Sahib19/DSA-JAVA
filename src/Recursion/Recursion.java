package Recursion;

public class Recursion {
    public static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return ;

        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return ;

        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int factorial(int n){
        if(n==1){
            return n;
        }else{
            return n*factorial(n-1);
        }
    }

    public static int SumOfN(int n){
        if(n==1){
            return 1;
        }else{
            return n+ SumOfN(n-1);
        }
    }

    public static int fibonacciNthTerm(int n){
        if(n==0 || n==1){
            return n ;
        }else{
            return fibonacciNthTerm(n-1)+fibonacciNthTerm(n-2);
        }
    }

    public static boolean checkSortedArray( int [] arr , int i ){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return checkSortedArray(arr,i+1);
    }

    public static int firstOccurrence(int [] arr , int i , int key){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurrence(arr,i+1,key);
    }

    public static int lastOccurrence(int [] arr , int i , int key){
        if(i == -1){
            return i;
        }
        if(arr[i] == key){
            return i;
        }
        return lastOccurrence(arr,i-1,key);
    }

    public static int PowerOfX(int x  , int n){
        if(n == 0 ){
            return 1;
        }else{
            return x*PowerOfX(x,n-1);
        }
    }

    //using simpler for loop - time complexity -O(n)
    // space complexity - O(n)
    public static String removeDuplicates(String str){
        if(str == null || str.isEmpty()){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char ch = str.charAt(0);
        sb.append(ch);
        for(int i = 1 ;  i< str.length() ; i++){
            ch = str.charAt(i);
            if(str.charAt(i) != str.charAt(i-1)) {
            sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeAllDuplicates(String str , int idx , StringBuilder sb , boolean [] map ){
        if(idx == str.length()){
            return sb.toString();
        }
        if(!map[str.charAt(idx) - 'a']){
            sb.append(str.charAt(idx));
            map[str.charAt(idx) - 'a'] = true;
        }

        return removeAllDuplicates(str,idx+1, sb , map);
    }

    public static int pairingProblem(int n ){
        if(n ==1 || n==2){
            return n ;
        }
        return (pairingProblem(n-1) )+(n-1)*(pairingProblem(n-2));
    }

    public static void BinaryStrings(int n , int lastPlace ,String str){
        // n==3
        //base case
        if(n==0){ // String Bane banate ham end me aa chuke hai
            System.out.println(str);
            return;
        }

        // if last place is  0
        BinaryStrings(n-1 , 0 , str+"0");
        if(lastPlace == 0){
            BinaryStrings(n-1 , 1 , str+"1");
        }
//        BinaryStrings(n-1 , 1 , str+"1");0 // when we need all the combinations

    }

    public static void TilingProblem(int n, String str) {

        // invalid case
        if (n < 0) {
            return;
        }

        // correct base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // place vertical tile
        TilingProblem(n - 1, str + "V");

        // place horizontal tiles
        TilingProblem(n - 2, str + "HH");
    }


    public static void main(String[] args ){
        TilingProblem(4,"");
    }
}
