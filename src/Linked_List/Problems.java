package Linked_List;

import java.util.*;

public class Problems {
    public static void printArr(int [] arr){
        for( int ele : arr){
            System.out.print(ele + " ");
        }
    }

    public static int[] rightMin(Stack <Integer> st, int  [] arr){
        int [] rightMin = new int [arr.length];
        for( int i =  arr.length-1 ; i>= 0 ; i--){
            int curr = arr[i];
            while(!st.isEmpty() && curr <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMin[i] = arr.length;
            }else{
                rightMin[i] = st.peek();
            }
            st.push(i);
        }

        return rightMin;
    }

    public static int[] leftMin(Stack <Integer> st, int  [] arr){
        int [] leftMin = new int [arr.length];
        for( int i = 0 ; i<  arr.length; i++){
            int curr = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= curr){
                st.pop();
            }
            if(st.isEmpty()){
                leftMin[i] = -1;
            }else{
                leftMin[i] = st.peek();
            }
            st.push(i);
        }

        return leftMin;
    }

    public static void MaxArea( int [] arr){
        Stack <Integer> s1 = new Stack <>();
        Stack <Integer> s2 = new Stack <>();
        int [] leftMin = leftMin(s1 , arr);
        int [] rightMin = rightMin(s2 , arr);
        int maxArea = Integer.MIN_VALUE;
        for( int i = 0 ; i < arr.length ; i++){
            int curr = arr[i] * (rightMin[i]-leftMin[i]-1);
            maxArea = Math.max(maxArea, curr);
        }

        System.out.println("The Max Area is " + maxArea);
    }


    public static void main(String[] args) {
        int [] arr = {2,1,5,6,2,3};
        Stack<Integer> st = new Stack<>();
        MaxArea(arr);



    }
}
