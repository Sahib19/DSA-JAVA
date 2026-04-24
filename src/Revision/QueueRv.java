package Revision;

class Queue {
    int[] Queue;
    int n; // total size of Queue that is Allocated
    int size; // it tells how much element is currently present in the queue
    int front;
    int rear;

    Queue(int n) {
        this.n = n;
        Queue = new int[n];
        size = 0;
        front = -1;
        rear = -1;
    }

    public void add(int data) {
        if (size == n) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) { // queue is Empty
            Queue[++front] = data;
            rear++;
            size++;
            return;
        }
        rear = rear + 1;
        Queue[rear] = data;
        size++;
    }

    public void remove() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        } else {
            int res = Queue[front];
            if (front == rear) {
                front = rear = -1;
                System.out.println(res);
                return;
            } else {
                for (int i = 1; i < size; i++) {
                    Queue[i - 1] = Queue[i];
                }
                rear--;
                System.out.println(res);
            }
            size--;
        }

    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void pQ() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        int temp = front;
        System.out.print("Front -> ");
        while (temp < size) {
            System.out.print(Queue[temp] + " - ");
            temp++;
        }
        System.out.println(" <-- rear");
    }
}


public class QueueRv {
    public static void main(String[] args) {
        Queue q1 = new Queue(5);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.pQ();
        q1.add(4);
        q1.pQ();
        q1.remove();
        q1.remove();
        q1.pQ();

    }
}
