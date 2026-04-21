package Linked_List;
import java.util.*;

public class Problems {
    public static class Node {
        char data;
        Node next;

        Node (char data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public void printLL(){
        Node temp =  head ;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void checkPalindrome(){
        if(head == null){
            System.out.println("LL is empty");
        }

        Stack <Character> st = new Stack <>();
        Node temp = head ;
        while(temp != null){
            st.push(temp.data);
            temp =  temp.next ;
        }

        temp = head ;
        while(temp != null){
            if(temp.data != st.pop()){
                System.out.println("Not a Palindrome");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Palindrome");
    }
     public static void main(String [] args){
        Problems ll = new Problems ();
        Node n1 = new Node ('s');
        head = n1 ;
        Node n2 = new Node ('a');
        Node n3 = new Node ('z');
        Node n4 = new Node ('s');
        n1.next = n2 ;
        n2.next = n3 ;
        n3.next = n4 ;
        ll.printLL();
        ll.checkPalindrome();
     }
}
