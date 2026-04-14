package Revision;

import java.util.*;

public class Revision2 {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("Ll is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addInMiddle(int data, int idx) {
        Node newNode = new Node(data);
        if (idx == 1) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 1;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Ll is empty");

            return;
        }

        if (head == tail) { // single element
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Ll is empty");
            return;
        }

        if (head == tail) { // single element
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }

    public void iterativeSearch(int data) {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }
        int idx = 1;
        Node temp = head;
        while (temp != null) {
            if (data == temp.data) {
                System.out.println("Element found at index " + idx);
                return;
            }
            temp = temp.next;
            idx++;
        }
        System.out.println("Element not found");
    }

    public void recursiveSearch(Node head, int data, int idx) {
        if (head == null) {
            System.out.println("Element not found");
            return;
        }

        if (head.data == data) {
            System.out.println("Element found at index " + idx);
            return;
        }

        recursiveSearch(head.next, data, idx + 1);
    }

    public static void reverseLl() {
        if (size == 0) {
            System.out.println("LL is empty");
            return;
        }

        if (head == tail) {
            return; // no need to reverse as only one element is present
        }
        tail = head;
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void deleteNthNode(int n) {
        if (head == null) {
            System.out.println("Ll is Empty");
            return;
        }

        if (n < 0 || n > size) {
            System.out.println("Invalid value");
            return;
        }

        if (size == n) { // it mean first node
            head = head.next;
            size--;
            return;
        }

        int des = size - n; // jo node delete krni hia usse just ek phele
        int i = 1;
        Node temp = head;
        while (i < des) {
            temp = temp.next;
            i++;
        }
        Node help = temp.next;
        temp.next = help.next;
        help.next = null;
    }

    // LL is plaindrome or not
    public Node findMid() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid of the Singly linked List
    }

    public boolean isPalindrome() {
        if (head == null) {
            System.out.println("Ll is empty");
            return false;
        }
        if (head == tail) {
            return true;
        }
        Node mid = findMid();

        Node prev = null;
        Node curr = mid;
        Node nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        Node leftPtr = head;
        Node rightPtr = prev;

        while (leftPtr != null && rightPtr != null) {
            if (leftPtr.data != rightPtr.data) {
                System.out.println("Not a Palindrome");
                return false;
            }
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }
        System.out.println("LL is Palindrome");
        return true;
    }

    public void detectCycle() {
        if (head == null) {
            System.out.println("Ll is empty");
            return;
        }

        if (head.next == head) {
            System.out.println("LL contain cycle with single element");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("It contain cycle");
                return;
            }
        }

        System.out.println("It not contain cycle");

        slow = head;
        Node prev = fast;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    //Applying merge sort on minked List
    public Node mMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node mergeSort(Node head) {
        if (head.next == null || head == null) {
            return head;
        }
        Node mid = mMid(head);
        Node lp = head;
        Node rp = mid.next;
        mid.next = null;
        Node left_part = mergeSort(lp);
        Node right_part = mergeSort(rp);

        return merge(left_part, right_part);

    }

    public Node merge(Node lp, Node rp) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (lp != null && rp != null) {
            if (lp.data <= rp.data) {
                temp.next = lp;
                lp = lp.next;
                temp = temp.next;
            } else {
                temp.next = rp;
                rp = rp.next;
                temp = temp.next;
            }
        }

        while (lp != null) {
            temp.next = lp;
            lp = lp.next;
            temp = temp.next;
        }

        while (rp != null) {
            temp.next = rp;
            rp = rp.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void zigzag() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }

        Node mid = findMid();
        Node leftHead = head;
        Node rightHead = mid;

        Node temp = new Node(-1);

        while (leftHead != null && rightHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;

            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

    }

    public void deleteNAfterM(int m, int n) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node mCurr = head;
        while (mCurr != null) {
            int i = 1;
            while (i < m && mCurr != null) {
                mCurr = mCurr.next;
                i++;
            }
            if (mCurr == null) {
                return;
            }

            Node nCurr = mCurr.next;
            int j = 1;
            while (j <= n && nCurr != null) {
                nCurr = nCurr.next;
                j++;
            }

            mCurr.next = nCurr;
            mCurr = nCurr;
        }

    }

    public void SwapNodes(int n1, int n2) {
        if (head == null || n1 == n2) { // no need to swap the nodes
            System.out.println("LL is empty");
            return;
        }

        Node prev1 = null;
        Node curr1 = head;
        while (curr1 != null && curr1.data != n1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node prev2 = null;
        Node curr2 = head;
        while (curr2 != null && curr2.data != n2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) {
            System.out.println("Element not found");
            return;
        }

        if (prev1 == null) {
            head = curr2;
        } else {
            prev1.next = curr2;
        }

        if (prev2 == null) {
            head = curr1;
        } else {
            prev2.next = curr1;
        }

        //Swaping agge walli nodes
        Node tmp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = tmp;

    }

    public void oddEven() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) { // it mean node contain even data
                if (evenHead == null) { // first element of even ll
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
                curr = curr.next;
            }else{ // it contain odd data
                if( oddHead == null){
                    oddHead = oddTail = curr;
                }else{
                    oddTail.next = curr ;
                    oddTail = curr;
                }
                curr = curr.next;
            }
        }

        // once we have even ll is odd ll
        head = evenHead;
        evenTail.next = oddHead ;
        tail = oddTail;
        oddTail.next = null ;
    }

    

    public static void main(String[] args) {
        Revision2 ll = new Revision2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(8);
        ll.printLL();
        ll.oddEven();
        ll.printLL();
    }
}
