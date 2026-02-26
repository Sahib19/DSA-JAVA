package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class PractiseSheet {
    public static void printBinary(int n) {
        Queue<String> q1 = new ArrayDeque<>();
        q1.add("1");

        while (n > 0) {
            String s = q1.remove();
            System.out.print(s + ", ");
            q1.add(s + "0");
            q1.add(s + "1");
            n--;
        }
    }



    public static void main(String[] args) {
        printBinary(10);
    }
}
