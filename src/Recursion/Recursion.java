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
    public static int owerOfX(int x  , int n){
        if(n == 0 ){
            return 1;
        }else{
            return x*PowerOfX(x,n-1);
        }
    }
    public static int PowerOX(int x  , int n){
        if(n == 0 ){
            return 1;
        }else{
            return x*PowerOfX(x,n-1);
        }
    }

    public static void main(String[] args ){
        System.out.println(PowerOfX(2,10));
    }
}
