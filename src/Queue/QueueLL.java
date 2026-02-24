package Queue;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

class StackUsing2Queue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public boolean isEmpty() {
        return q1.size() == 0 && q2.size() == 0;
    }

    public void add(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    public int remove() {
        if (q1.isEmpty() && q2.isEmpty()) {
            // both queues are empty
            System.out.println("Queue is Empty");
            return -1;
        }

        if (!q1.isEmpty() && q2.isEmpty()) {
            while (q1.size() != 1) {
                q2.add(q1.remove());
            }
            // at this point q1 contain only one element
            return q1.remove();
        } else {
            while (q2.size() != 1) {
                q1.add(q2.remove());
            }
            // at this point q1 contain only one element
            return q2.remove();
        }
    }
}

class QueueUStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public void add(int data) {  // O(n)
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int remove() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }
}

public class QueueLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public static Node front;
    public static Node rear;

    public static boolean isEmpty() {
        return front == null;
    }

    public static void add(int data) {
        // creation of new node
        Node newnode = new Node(data);

        if (isEmpty()) {
            front = rear = newnode;
            return;
        }
        rear.next = newnode;
        rear = newnode;
    }

    public static int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int val = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return val;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return front.data;
    }


    public static void main(String[] args) {
//            QueueLL q1 = new QueueLL();
//            q1.add(1);
//            q1.add(2);
//            q1.add(3);
//            q1.add(4);
//            System.out.println(q1.peek());
//            System.out.println(q1.remove());
//            System.out.println(q1.peek());
//        QueueUStack q2 = new QueueUStack();
//        q2.add(2);
//        q2.add(4);
//        q2.add(6);
//        System.out.println(q2.peek());
//        System.out.println(q2.remove());
//        System.out.println(q2.peek());
        StackUsing2Queue st = new StackUsing2Queue();
        st.add(5);
        st.add(4);
        st.add(3);
        System.out.println(st.remove());
    }
}
