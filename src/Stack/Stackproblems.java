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
    public static void main (String [] args){

        Stack< Integer> s =  new Stack <>();
//        addElementAtBottom(10 , s);
//        System.out.println(s);

//        Stack< Character> stack =  new Stack <>();
//        String str = "abc";
//        String res = reverseString(str,stack);
//        System.out.println(res);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);


    }
}
