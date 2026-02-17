package Linked_List;

public class CircularLL {

    public static class Node{
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
        }

    }

    public static Node head ;
    public static Node tail ;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = newNode;
            return;
        }
        newNode.next = head ;
        head = newNode;
        tail.next = head ;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head ;
        tail = newNode;
    }

    public void deleteFirst(){
        if(head == null && tail == null){
            System.out.println("Linked list is empty");
            return ;
        }

        if(tail.next == tail ){ // one element is present
            head = tail = null ;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    public void deleteLast(){
        if(head == null && tail == null){
            System.out.println("Linked list is empty");
            return ;
        }

        if(tail.next == tail ){ // one element is present
            head = tail = null ;
            return;
        }

        Node temp = head ;
        while(temp.next != tail){
            temp = temp.next;
        }
        // temp is just one element before tail
        temp.next = head;
        tail = temp ;
    }

    public void Pdll(){
        if(head == null){
            System.out.println("Linked list is Empty");
            return;
        }

        Node temp = head ;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("->head");
    }

    public static void main(String [] args){
        CircularLL ll = new CircularLL();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.Pdll();
        ll.deleteFirst();
        ll.deleteLast();
        ll.Pdll();


    }
}
