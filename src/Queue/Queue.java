package Queue;

// Implementation of Circular Queue
class queue2 {
    static int[] arr;
    static int front;
    static int rear;
    static int size;

    queue2(int n) {
        arr = new int[n];
        front = -1;
        rear = -1;
        size = n;

    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {// The is Queue is empty
            front = 0;
        }
        rear = (rear + 1) % size;

        arr[rear] = data;

    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return -1;
        }
        int res = arr[front];
        if (front == rear) {
            // only one element exist
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return res;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];

    }
}

public class Queue {
    //    public static class QueueArr{
//        static int [] arr ;
//        static int size ;
//        static int rear ;
//
//        QueueArr(int n){
//            arr = new int [n];
//            size = n ;
//            rear = -1 ;
//        }
//
//        public static boolean isEmpty(){
//            return rear == -1 ;
//        }
//
//        public static void add ( int data){
//            if(rear == size-1){
//                System.out.println("Queue is full");
//                return ;
//            }
//            rear = rear+1;
//            arr[rear] = data ;
//        }
//
//        public static int remove(){
//            if(isEmpty()){
//                System.out.println("Queue us Empty");
//                return -1;
//            }
//            int front = arr[0];
//            for( int i = 0 ; i< rear ; i++){
//                arr[i] = arr[i+1];
//            }
//            rear--;
//            return front;
//        }
//
//        public static int peek(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//            }
//            return arr[0];
//        }
//    }
    public static void main(String[] args) {
//          QueueArr q = new QueueArr(10);
//          q.add(1);
//          q.add(2);
//          q.add(3);
//          System.out.println(q.peek());
//          System.out.println(q.remove());
//          System.out.println(q.remove());
//          System.out.println(q.peek());

        queue2 q2 = new queue2(5);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);
        q2.add(5);
        q2.remove();

        System.out.println(q2.peek());
    }

}
