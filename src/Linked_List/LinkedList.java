package Linked_List;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data ;
        }
    }

    // Creating Head Point Toward first element
    public static Node head;

    // Creating Tail -> points toward last element
    public static Node tail;

    // Creating Method to manipulate linked List

    //Adding element to the first
    public void addFirst(int data){
        Node newNode = new Node(data); // creation of new data

        // checking whether ll is total empty or have some element
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head ; // new node ka next point krege jisse head point kr raha tha

        head = newNode;
    }

    //Adding element to the last
    public void addLast(int data){
        // node creation
        Node newnode = new Node(data);

        if(head == null) { //  LL is empty
            head = tail = newnode;
            return;
        }

        tail.next = newnode; // jo last node hai vo abb null ki jaga newnode ko point kre

        // Now the Tail will point to last node ie newNode
        tail = newnode ;

    }

    public void printLL(){
        Node temp = head;

        if(head == null){
            System.out.println("LL is empty");
            return;
        }

        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public int sizeOfLL(){
        int count = 0;
        if(head == null){
            return count;
        }
        Node iterator = head;
        while(iterator != null){
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("LL is Empty !!");
            return;
        }

        System.out.println("Node with data "+head.data+" is Removed ");

        head = head.next;

    }

    public void removeLast(){
        if(head == null){
            System.out.println("LL is Empty !!");
            return;
        }

        System.out.println("Node with data "+tail.data+" is Removed ");

        head = head.next;

    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.printLL();
        ll.removeFirst();
        ll.printLL();




    }
}
