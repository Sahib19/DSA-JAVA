package Revision;

import java.util.*;

public class QueueRv {
    Stack <Integer> s1 = new Stack<>(); // adding purpose

    Stack <Integer> s2 = new Stack<>(); // removing purpose
    int front = -1 ;
    int rear = -1 ;
    int size = 0 ;

    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }

    public void add( int data){ // O(1)
        s1.add(data);
    }

    public int remove(){ // O(n)
        if(isEmpty()){
            System.out.println("Queue is Empty !!!!!");
            return -1;
        }

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }



    public static void main(String[] args) {
        QueueRv q1 = new QueueRv();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        System.out.println(q1.remove());
        System.out.println(q1.remove());

    }
}
