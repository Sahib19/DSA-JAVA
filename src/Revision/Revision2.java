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

    public void iterativeSearch(int data){
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }
        int idx = 1 ;
        Node temp = head ;
        while(temp != null){
            if(data == temp.data){
                System.out.println("Element found at index "+idx);
                return;
            }
            temp = temp.next;
            idx++;
        }
        System.out.println("Element not found");
    }

    public void recursiveSearch( Node head ,int data , int idx ) {
        if(head == null){
            System.out.println("Element not found");
            return;
        }

        if(head.data == data){
            System.out.println("Element found at index "+ idx);
            return;
        }

        recursiveSearch(head.next , data , idx+1);
    }

    public static void main(String[] args) {
        Revision2 ll = new Revision2();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.printLL();
        ll.addInMiddle(10, 3);
        ll.printLL();
        ll.iterativeSearch(10);
        ll.recursiveSearch(head , 10,1);

    }
}
