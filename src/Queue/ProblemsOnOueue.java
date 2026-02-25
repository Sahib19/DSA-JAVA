package Queue;

import java.util.*;
import java.util.Queue;

public class ProblemsOnOueue {

    // O(N)
    public static void NonrepeatingChar(String str) {
        Queue<Character> q1 = new LinkedList<>();
        int[] freq = new int[26];


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Incrementing this char in freq array
            freq[ch - 'a']++;
            q1.add(ch);
            while (!q1.isEmpty() && freq[q1.peek() - 'a'] > 1) {
                q1.remove();
            }
            if (q1.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q1.peek() + " ");

            }

        }
    }

    public static void InterleavingQueue(Queue<Integer> q1) {
        int size = q1.size();
        Queue<Integer> q2 = new LinkedList<>();

        while (q1.size() != size / 2) {
            q2.add(q1.remove());
        }

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }

    public static void QueueReversal(Queue <Integer> q1){
        Stack <Integer> st = new Stack <>();

        while(!q1.isEmpty()){
            st.push(q1.remove());
        }
        while(!st.isEmpty()){
            q1.add(st.pop());
        }
    }

    public static void main(String[] args) {

//        NonrepeatingChar("aabccxb");
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        InterleavingQueue(q1);
//        System.out.println(q1);
        QueueReversal(q1);
        System.out.println(q1);


    }
}
