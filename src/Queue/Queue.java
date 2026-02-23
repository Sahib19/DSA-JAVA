package Queue;

public class Queue {
    public static class QueueArr{
        static int [] arr ;
        static int size ;
        static int rear ;

        QueueArr(int n){
            arr = new int [n];
            size = n ;
            rear = -1 ;
        }

        public static boolean isEmpty(){
            return rear == -1 ;
        }

        public static void add ( int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return ;
            }
            rear = rear+1;
            arr[rear] = data ;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue us Empty");
                return -1;
            }
            int front = arr[0];
            for( int i = 0 ; i< rear ; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String [] args){
          QueueArr q = new QueueArr(10);
          q.add(1);
          q.add(2);
          q.add(3);
          System.out.println(q.peek());
          System.out.println(q.remove());
          System.out.println(q.remove());
          System.out.println(q.peek());
    }

}
