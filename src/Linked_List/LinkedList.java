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

    // Variable to track the LL size
    public  int size ;

    // Creating Method to manipulate linked List

    //Adding element to the first
    public void addFirst(int data){
        Node newNode = new Node(data); // creation of new data

        // checking whether ll is total empty or have some element
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head ; // new node ka next point krege jisse head point kr raha tha

        head = newNode;
        size++;
    }

    //Adding element to the last
    public void addLast(int data){
        // node creation
        Node newnode = new Node(data);

        if(head == null) { //  LL is empty
            head = tail = newnode;
            size++;
            return;
        }

        tail.next = newnode; // jo last node hai vo abb null ki jaga newnode ko point kre

        // Now the Tail will point to last node ie newNode
        tail = newnode ;
        size++;

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
        if(size == 0){
            System.out.println("LL is Empty !!");
            return;
        }else if(size == 1){
            System.out.println("Node with data "+head.data+" is Removed ");
            head=tail=null;
            size--;
            return ;
        }
        System.out.println("Node with data "+head.data+" is Removed ");

        head = head.next;
        size--;

    }

    public void removeLast(){
        if(size==0){
            System.out.println("LL is Empty !!");
            return;
        }else if (size == 1){
            System.out.println("Node with data "+tail.data+" is Removed ");
            head=tail=null;
            size = 0 ;
            return ;
        }

        Node prev = head ;
        for( int i = 0 ; i < size-2 ; i++){
            prev = prev.next;
        }

        System.out.println("Node with data "+ prev.next.data+" is Removed ");
        tail = prev;
        prev.next = null ;
        size--;

    }

    public void addInMiddle(int index , int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node Newnode = new Node(data);
        Node temp = head ;
        int i = 0 ;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }

        // when temp is in the previous
        Newnode.next  = temp.next;
        temp.next = Newnode;
        size++;

    }

    // Iterative SEARCH

    public int iterativeSearch(int key ){
        Node temp = head ;
        int i = 0 ;
        while(temp != null ){
            if(temp.data == key){
                System.out.println("Element found at index "+i);
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Element not found");
        return -1 ;
    }

    public int recursiveSearch( Node head , int key , int i){
        if( head == null){
            System.out.println("LL is not Empty ");
            return -1 ;
        }

        if(head.data == key){
            System.out.println("Element Found at index "+ i);
            return i;
        }

        return recursiveSearch(head.next , key , i+1);
    }

    public void reverseLL(){
        // three variables used [ prev - curr - next ]
        Node prev = null ;
        Node curr = tail =  head ;
        Node next ;

        while(curr != null ){
            next = curr.next;
            curr.next = prev ;

            prev = curr ;
            curr= next ;
        }

        head = prev ;

    }

    public void deleteNthFromLast(int n){

        if(head == null){
            System.out.println("The ll is empty");
            return;
        }

        // Step 1: Find size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            sz++;
            temp = temp.next;
        }

        if(n > sz || n <= 0){
            System.out.println("Invalid n");
            return;
        }

        // If deleting first node
        if(n == sz){
            head = head.next;
            size--;
            if(head == null){
                tail = null;
            }
            return;
        }

        Node prev = head;
        int dest = sz - n;

        for(int i = 1; i < dest; i++){
            prev = prev.next;
        }

        if(prev.next == tail){
            tail = prev;
        }

        prev.next = prev.next.next;
        size--;
    }



    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.printLL();
//        ll.reverseLL();
        ll.deleteNthFromLast(3);
        ll.printLL();







    }
}
