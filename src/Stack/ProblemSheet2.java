package Stack;
import java.util.Stack;

public class ProblemSheet2 {
    // printing array
    public static void printArr(int [] arr){
        for(int el : arr){
            System.out.print(el+" ");
        }
        System.out.println();
    }

    // Max Area In a Histogram

    public static void NextMinFromRight(int [ ] nums ,  int [] rightMinArr){
        Stack <Integer> st = new Stack<>();

        for(int i = nums.length-1 ; i >= 0; i-- ){
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] >= curr){
                st.pop();
            }
            if(st.isEmpty()){
                rightMinArr[i] = nums.length ;
            }else{
                rightMinArr[i] = st.peek() ;
            }
            st.push(i);
        }
    }

    public static void NextMinFromLeft(int [ ] nums ,  int [] leftMinArr){
        Stack <Integer> st = new Stack<>();

        for(int i = 0  ; i < nums.length; i++ ){
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] >= curr){
                st.pop();
            }
            if(st.isEmpty()){
                leftMinArr[i] = -1 ;
            }else{
                leftMinArr[i] = st.peek() ;
            }
            st.push(i);
        }
    }

    // Main histogram Code
    public static void MaxAreaRectangle(){
        int [] num = {4,2};
        int [] rightMinArr = new int [num.length];
        int [] leftMinArr = new int [num.length];
        NextMinFromLeft(num,leftMinArr); //
        NextMinFromRight(num,rightMinArr);

        int maxRecArea  = Integer.MIN_VALUE;
        int currRecArea ;
        for(int i = 0 ; i < num.length ; i++ ){
            currRecArea = num[i] * ((rightMinArr[i] - leftMinArr[i] )-1);
            maxRecArea = Math.max(maxRecArea , currRecArea);
        }

        System.out.println("The Max Area Rectangle Area is "+maxRecArea);

    }

    public static void main(String [] args){
        System.out.println("Histogram program ");
        MaxAreaRectangle();

    }
}
