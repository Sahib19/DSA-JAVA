package Linked_List;

public class DoublyLL {
    public static class Node{
        int data ;
        Node next ;
        Node prev ;

        Node(int data){
            this.data = data ;
            this.next = null ;
            this.prev = null ;
        }
    }

    // jo bhi object ( node ) banege for the class
    //sabke liye ye donot head and tail common rahege

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            size++;
            head = tail = newnode ;
            return;
        }
        newnode.next = head ;
        head.prev = newnode ;
        head = newnode;
        size++;
    }

    public void addLast(int data){
        Node newnode = new Node(data);
        if(head == null){
            size++;
            head = tail = newnode ;
            return;
        }

        tail.next = newnode;
        newnode.prev = tail ;
        tail = newnode;
        size++;
    }

    public void removeFirst(){
        if(head==null){
            System.out.println("Doubly LL is empty");
            return;
        }
        if(head.next == null){ // it mean only one elemnt is present
            head = tail = null ;
            size--;
            return;
        }

        head = head.next;
        head.prev = null ;
        // no need to break teh connection between the node that is going
        // to delete next with  its next node
        size--;
    }

    public void removeLast(){
        if(head==null){
            System.out.println("Doubly LL is empty");
            return;
        }
        if(head.next == null){ // it mean only one elemnt is present
            head = tail = null ;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;

    }

    public void printDLL(){
        if(head == null){
            System.out.print("Linked List is empty");
        }
        Node temp = head ;
        while(temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseLL(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        tail = head;
        Node prev = null ;
        Node curr = head ;
        Node next ;

        while( curr != null){
            next = curr.next;
            curr.prev = next ;
            curr.next =prev ;

            prev = curr ;
            curr = next ;
        }

        head = prev ;
    }

    public static void main(String [] args){
        DoublyLL ll = new DoublyLL();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(6);
        ll.printDLL();
        ll.reverseLL();
        ll.printDLL();
    }
}
