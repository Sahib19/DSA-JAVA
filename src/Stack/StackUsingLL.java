package Stack;

public class StackUsingLL {
    public static class StackLL{
        int data ;
        StackLL next ;
        StackLL(int data){
            this.data = data;
        }

    }
    public static StackLL top;

    public boolean isEmpty(){
        return top == null ;
    }

    public void push(int data){
        StackLL newNode = new StackLL(data);
        if(top == null ){
            top = newNode;
            return;
        }
         newNode.next = top;
        top = newNode ;
    }

    public  int pop(){
        if(top == null){
            System.out.println("Stack is Empty");
            return -1;
        }

        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1 ;
        }
        return top.data;
    }

    public void PrintS(){
        if(top == null){
            System.out.println("Stakc is empty");
            return;
        }
        StackLL temp = top ;
        System.out.print("TOS->");
        while(temp != null){
            System.out.print(temp.data+"-");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String [] args){
        StackUsingLL list = new StackUsingLL();
        list.push(1);
        list.push(2);
        list.push(3);
        list.PrintS();
        System.out.println(list.peek());
        System.out.println(list.pop());
        list.PrintS();

    }
}
