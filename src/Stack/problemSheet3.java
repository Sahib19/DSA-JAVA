package Stack;
import java.util.Stack;

public class problemSheet3 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

        public static Node head;
        public static Node tail;

        public static void addFirst(int data){
            Node newnode = new Node(data);
            if(head == null){
                //LL is empty
                head = tail = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
        }

        public static void printll(){
            if(head ==  null){
                System.out.println("Ll is Empty");
                return;
            }
            Node temp = head ;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public static void checkPalindrome(){
            if(head==null){
                System.out.println("Ll is empty");
                return ;
            }

            Stack <Integer> st = new Stack<>();
            Node temp = head;
            while(temp != null){
                st.push(temp.data);
                temp = temp.next;
            }
            temp = head;

            while(!st.isEmpty()){
                if(st.pop() != temp.data){
                    System.out.println("Not a palindrome");
                    return;
                }
                temp = temp.next;
            }

            System.out.println("palindrome");
            return;
        }

    public static void main(String[] args){
        problemSheet3 ll = new problemSheet3();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(52);
        ll.addFirst(5);
        ll.checkPalindrome();
        ll.printll();
    }
}
