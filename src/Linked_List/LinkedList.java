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

    // Checking whether the linked list palindrome or not

    // Code to find mid of array list
    public Node findMid( Node head){
        Node slow = head ;
        Node fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next ; // +1
            fast = fast.next.next; //+2
        }

        return slow ; // this is our mid of the Linked List

    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //finding mid
        Node mid = findMid(head);

        // reversing the LL from Mid
        Node prev = null ;
        Node curr = mid ;
        Node next ;

        while(curr != null ){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        // Using 2 pointer checking palindrome condition
        Node leftPtr = head ;
        Node rightPtr = prev ;

        while(rightPtr != null && leftPtr != null){
            if(leftPtr.data != rightPtr.data){
                return false;
            }
            rightPtr = rightPtr.next;
            leftPtr = leftPtr.next;
        }
        return true;

    }

    public static boolean containCycle(){
        Node slow = head ;
        Node fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;

            if(slow == fast){
                System.out.println("Oops!! Contain cycle");
                return true;
            }
        }

        return false;
    }

    // Code to Merge two Linked List

    // Find the mid part of the given Linked list

    public Node findMidMS(Node head){
        Node slow = head ;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow ; // returning the mid back
    }

    public Node merge(Node left , Node right){
        // Creation of temp LL
        Node tempLL = new Node(-1);
        Node temp = tempLL;

        while(left != null && right != null){
            if(left.data <= right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while(left != null ){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return tempLL.next;
    }

    public Node mergeSort(Node head){
        //Base Case
        if(head == null || head.next == null){
            return head ;
        }

        Node mid  = findMidMS(head);
        Node rightHead = mid.next;
        mid.next = null ;
        Node leftPart = mergeSort(head);
        Node rightPart  = mergeSort(rightHead);

        return merge(leftPart, rightPart);
    }

    // Zig zag Linked list

    // Reversing the second part of LL
    public Node reverseSecondPart(Node head){
        Node prev = null ;
        Node curr = head ;
        Node next ;

        while(curr!=null){
            next = curr.next;
            curr.next = prev ;
            prev=curr;
            curr= next;
        }
        //the prev will be the head
        return prev;
    }

    public Node zigZackLL(){
        // find the mid
        Node mid = findMidMS(head);
        // ll1 with head = head
        // ll2 with head mid.next;
        Node Lh = head ;
        Node Rh = reverseSecondPart(mid.next);
        mid.next= null ;
        Node nextL = Lh;
        Node nextR = Rh;

        while(nextL != null && nextR != null ){
            nextL = Lh.next;
            Lh.next = Rh;
            nextR = Rh.next;
            Rh.next =nextL;

            Lh = nextL;
            Rh = nextR;

        }
         return head;
    }

    // Assignments Problems
    public void delete_N_NodesAfter_M_(int m , int n){
        if(head == null ){
            System.out.println("Linked list is Empty");
            return ;
        }
        Node curr = head ;
        while(curr != null){



            // taking m nodes
            for ( int i =1 ; i < m && curr != null ; i++){
                curr = curr.next;
            }

            if(curr == null){
                return;
            }

            Node temp = curr.next ;
            for( int j = 1 ; j <= n && temp != curr; j++){
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    //Problem 2 -> Swapping of 2 nodes
    public void swappingNodes( int d1 , int d2 ){
        if(head == null || d1 == d2){
            System.out.println("The list is empty");
            return;
        }

       // Initialisation the Extra Node variable that we are doing
        Node prev1 = null , curr1 = head ;
        Node prev2 = null , curr2 = head ;

        // finding where d1 is located
        while(curr1 != null && curr1.data != d1){
            prev1 = curr1 ;
            curr1 = curr1.next;
        }

        // finding where d2 is located
        while(curr2 != null && curr2.data != d2){
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if(curr1 == null || curr2 == null ){ // koi ke value exist nhi krti ll me
            return;
        }

        // if d1 is not at head position
        if(prev1 != null){
            prev1.next = curr2;
        }else{
            head = curr2 ;
        }

        // if d2 is not at head position
        if(prev2 != null){
            prev2.next = curr1;
        }else{
            head = curr1 ;
        }

        // Swap next pointers
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

    }

    // Odd even linked list problem
     public void OddEvenLL(){
        if(head == null ){
            System.out.println("LL is empty");
            return;
        }
       Node evenHead = null , evenTail = null;
       Node oddHead = null , oddTail = null;
       Node curr = head ;

        while(curr != null){
            Node nextNode = curr.next ;
            curr.next = null;
            if(curr.data %2 == 0 ){ // the number is even
                if(evenHead == null){
                    // the list is empty
                    evenHead = evenTail = curr ;
                }else{
                    evenTail.next = curr ;
                    evenTail = evenTail.next;
                }
        }else{
                if(oddHead == null){
                    oddHead = oddTail = curr ;

                }else{
                    oddTail.next = curr ;
                    oddTail = oddTail.next;
                }
            }
            curr = nextNode;
        }

        if(evenHead == null ){
            head = oddHead;
            tail = oddTail;
        }else if(oddHead == null){
            head = evenHead;
            tail = evenTail;
        }else{
            head = evenHead;
            evenTail.next = oddHead;
            oddTail.next = null ;
            tail = oddTail;
        }

    }


    public static void main(String[] args){
        LinkedList ll = new LinkedList();

//        ll.addFirst(3);
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.addLast(2);
//        ll.addLast(1);
//
//        ll.printLL();
////        ll.reverseLL();
//        System.out.println(ll.isPalindrome());

//        head = new Node (1);
//        head.next = new Node (2);
//        head.next.next = new Node (3);
//        head.next.next.next = head;
//        System.out.println(containCycle());

//        ll.addFirst(1);
        ll.addFirst(2);
//        ll.addFirst(3);
        ll.addFirst(4);
//        ll.addFirst(5);
        ll.addFirst(6);
//        ll.addFirst(7);
//        ll.addFirst(8);
        ll.printLL();
        ll.OddEvenLL();
        ll.printLL();








    }
}
