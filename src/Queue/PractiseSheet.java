package Queue;

import java.util.*;
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

    public static int minimumRopeCost(PriorityQueue<Integer> pq) {
        int minCost = 0;

        while (pq.size() > 1) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            minCost += (s1 + s2);
            pq.add(s1 + s2);
        }

        return minCost;

    }

//    public static void jobSequencing(){}

    public static void ReverseFirstK(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size()) {
            return;
        }

        Stack<Integer> st = new Stack<>();
        int size = q.size() - k;

        for (int i = 1; i <= k; i++) {
            st.push(q.remove());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        for (int i = 1; i <= size; i++) {
            q.add(q.remove());
        }
    }

    public static void maxFromFirstK(int[] arr, int k) {
    // Sliding Window Problem
        Deque <Integer> q1 = new ArrayDeque <>();
        Queue <Integer> result = new ArrayDeque <>();

        //First K element
        for( int i = 0 ; i< k ; i++){
            while (!q1.isEmpty() && arr[i] >= arr[q1.peekLast()] ){
                q1.removeLast();
            }
            q1.addLast(i);
        }

        // sliding window for another Window
        for(int i = k ; i < arr.length ; i++){
            result.add(arr[q1.peekFirst()]);

            // removing that element that does not belong to that window
            while(q1.size() > 0 && q1.peekFirst() <= i-k){
                q1.removeFirst();
            }

            //
            while (!q1.isEmpty() && arr[i] >= arr[q1.peekLast()] ){
                q1.removeLast();
            }
            q1.addLast(i);
        }

        result.add(arr[q1.peekFirst()]);
        System.out.println(result);

    }


    public static void main(String[] args) {
//        printBinary(10);
//        System.out.println(minimumRopeCost(pq));
//        Queue <Integer> q1 = new ArrayDeque <>(Arrays.asList(1,2,3,4,5));
//        ReverseFirstK(q1,3);
//        System.out.println(q1);
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        maxFromFirstK(arr, 3);

    }
}
