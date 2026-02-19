package Stack;

import java.util.Stack;

public class Stackproblems {
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
    public static void main (String [] args){

        Stack< Integer> s =  new Stack <>();
        s.push(1);
        s.push(2);
        s.push(3);
        addElementAtBottom(10 , s);
        System.out.println(s);
    }
}
