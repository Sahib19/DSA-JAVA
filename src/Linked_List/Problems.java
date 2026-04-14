package Linked_List;
import java.util.*;

public class Problems {
    public static void addAtBottom(int data , Stack <Integer> st){
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int val = st.pop();
        addAtBottom(data,st);
        st.push(val);

    }
    public static void main(String[] args) {
        Stack <Integer> st = new Stack <>();
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st);
        addAtBottom(10,st);
        System.out.println(st);



    }
}
