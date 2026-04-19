package Linked_List;

import java.util.*;

public class Problems {
    public static boolean validParenthesis(Stack<Character> st, String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                else if (ch == '}' && st.peek() == '{'
                        || ch == ']' && st.peek() == '['
                        || ch == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        System.out.println(validParenthesis(st, "{["));


    }
}
