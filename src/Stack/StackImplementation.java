package Stack;
import java.util.ArrayList;

public class StackImplementation {
    static class stack{
        static ArrayList <Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size() == 0 ;
        }

        public void push(int data){
            list.add(data);
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack UnderFlow");
                return -1;
            }

            int val = list.getLast();
            list.remove(list.size() -1);
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack UnderFlow");
                return -1;
            }
            return list.get(list.size()-1);
        }

    }
    public static void main(String[] args){
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
//        System.out.println(s.list);
//        System.out.println(s.peek());
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.pop());


    }
}
