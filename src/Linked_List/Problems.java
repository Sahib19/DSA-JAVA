package Linked_List;
import java.util.*;

public class Problems {
    public static void bottomAdd(Stack <Integer> st , int  ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }

        int curr = st.pop();
        bottomAdd(st ,  ele) ;
        st.push(curr);
    }

    public static void reverseStack(Stack <Integer> st){
        if(st.isEmpty()){
            return;
        }
        int curr = st.pop();
        reverseStack(st);
        bottomAdd(st,curr);
    }
    public static void main(String[] args) {
        Stack <Integer> st = new Stack <>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);




    }
}
