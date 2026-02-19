package Linked_List;


public class Problems {

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode head;
    public ListNode tail;

    // ✅ Function to add node at first
    public void addFirst(int data) {

        ListNode newNode = new ListNode(data);

        // Case 1: If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Case 2: If list already has elements
        newNode.next = head;
        head = newNode;
    }

    // ✅ Function to print linked list
    public void printList() {

        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Problems list = new Problems();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.printList();

        Problems list2 = new Problems();
        list2.addFirst(8);
        list2.addFirst(6);
        list2.addFirst(5);
        list2.printList();

        Problems list3 = new Problems();
        list3.addFirst(15);
        list3.addFirst(13);
        list3.addFirst(9);
        list3.printList();
        System.out.println(list.head.data);


    }
}
