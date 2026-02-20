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
        System.out.println(duplicateParenthesis("((a+b)+(c+d))"));

    }
}
