package Revision;

import java.util.*;

public class QueueRv {

    public static Stack <Integer> st = new Stack <>();

    public void add(int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int top = st.pop();
        add(data);
        st.push(top);
    }

    public void remove(){
        if(st.isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }

        int ele = st.pop();
        System.out.println(ele + " removed ");
    }
    public static void main(String[] args) {
        QueueRv q1 = new QueueRv();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.remove();

    }
}
