package Stack;

import java.util.Stack;

public class Stackproblems {

    public static String reverseString(String str , Stack< Character> stack){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);
        stack.push(ch);
        return reverseString(str.substring(1) , stack) + stack.pop();
    }

    public static void addElementAtBottom(int data, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int top = st.peek();
        st.pop();
        addElementAtBottom(data , st);
        st.push(top);

    }

    public static void reverseStack(Stack <Integer> st){
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();
        reverseStack(st);
        addElementAtBottom(top,st);

    }

    public static void ValidParentheses(String str){
        Stack <Character> st =  new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            if(ch == '[' || ch == '{' || ch == '(' ){
                st.push(ch);
            }else{// if it is a closing bracket
                if(st.isEmpty()){
                    System.out.println("Not a valid Parentheses");
                    return;
                }else {
                    if (( ch == ']' && st.peek() == '[' ) ||
                        ( ch == '}' && st.peek() == '{' ) ||
                        ( ch == ')' && st.peek() == '(' )  )
                    {
                        st.pop();
                    } else
                    {
                    System.out.println("Not a valid Parentheses");
                    return;
                    }
                }
            }
        }

        if(st.isEmpty()){
            System.out.println("It is a valid Parentheses");
        }else{
            System.out.println("Not a valid Parentheses");
        }


    }

    public static boolean duplicateParenthesis(String str){
        Stack <Character> st = new Stack <>();
        for( int i = 0  ; i<str.length() ; i++){
            char ch = str.charAt(i);

            if(ch != ')'){
                st.push(ch);
            }else{ // agar ch me -> ) aa geya then find its closing by removing element
                // form stack
                int count = 0 ;
                while (!st.isEmpty() && st.peek() != '('){
                    st.pop();
                    count++;
                }
                if(st.isEmpty()){
                    //invalid input
                    System.out.println("Invalid Input");
                    return false;
                }
                if(count < 1){
                    return true;
                }
                st.pop();
            }
        }
            return false;

    }

    //Stock span problem -> here we have to find the span of given data
    public static void StockSpanProblem(int [] arr , int [] span){
        Stack <Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1 ; // always true

        for( int i = 1 ;  i < arr.length ; i++){
            int currPrice = arr[i];

            while( !st.isEmpty() && arr[st.peek()] <= currPrice ){
                st.pop();
            }

            if(st.isEmpty()){
                span[i] = i+1;
            }else {
                int prevHigh = st.peek();
                int spanValue = i - prevHigh;
                span[i] = spanValue;
            }
            st.push(i); // pushing the index in the stack
        }
    }

    //
    public static void NextGreaterOnRight(int[ ] nums , int [] nextGArr){
        Stack <Integer> st =  new Stack<>();

        for(int i = nums.length-1 ; i >= 0 ; i--){
            int curr = nums[i];

            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }
            if(st.isEmpty()){
                nextGArr[i] = -1 ;
            }else{
                nextGArr[i] = st.peek();
            }
            st.push(curr);
        }
    }

    //Next greater on left
    public static void NextGreaterOnLeft(int [] nums , int [] nextGArr){
        Stack <Integer> st =  new Stack<>();

        for ( int i =  0 ; i< nums.length ; i++){
            int curr = nums[i];

            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }
            if(st.isEmpty()){
                nextGArr[i] = -1 ;
            }else{
                nextGArr[i] = st.peek() ;

            }
            st.push(curr);
        }
    }
     // next Smallest on immediate right
    public static void NextSmallestOnRight(int[ ] nums , int [] nextGArr){
        Stack <Integer> st =  new Stack<>();

        for(int i = nums.length-1 ; i >= 0 ; i--){
            int curr = nums[i];

            while(!st.isEmpty() && st.peek() >= curr){
                st.pop();
            }
            if(st.isEmpty()){
                nextGArr[i] = -1 ;
            }else{
                nextGArr[i] = st.peek();
            }
            st.push(curr);
        }
    }

    public static void main (String [] args){

        Stack< Integer> s =  new Stack <>();
//        addElementAtBottom(10 , s);
//        System.out.println(s);

//        Stack< Character> stack =  new Stack <>();
//        String str = "abc";
//        String res = reverseString(str,stack);
//        System.out.println(res);
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println(s);
//        reverseStack(s);
//        System.out.println(s);

//        ValidParentheses("{}({)()");
//        System.out.println(duplicateParenthesis("((a+b)+(c+d))"));
        int [] arr = {100,80,60,70,60,85,100};
        int [] span = new int [arr.length];
//        StockSpanProblem(arr , span );
        System.out.println("100,80,60,70,60,85,100");
//        NextGreaterOnRight(arr,span);
//        NextGreaterOnLeft(arr,span);
        NextSmallestOnRight(arr,span);
        for(int i = 0 ; i< span.length ; i++){
            System.out.print(span[i]+" ");
        }

    }
}
