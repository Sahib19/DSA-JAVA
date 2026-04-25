package Revision;

import java.util.*;

public class QueueRv {
    public static void printBinary(int n) {

        Queue<String> q1 = new ArrayDeque<>();
        q1.add("1");

        while (n > 0) {
            String curr = q1.remove();
            System.out.print(curr + " ");
            q1.add(curr + "0");
            q1.add(curr + "1");
            n--;
        }
    }

    public static void SlidingWindowProblem(int[] arr, int k) {
        //k  -> Window Size

        Queue<Integer> res = new ArrayDeque<>(); // to store result
        Deque<Integer> helper = new ArrayDeque<>(); // as a helper queue

        int i = 0;
        // analyzing first k window
        for (; i < k; i++) {
            while (!helper.isEmpty() && arr[i] > arr[helper.peekLast()]) {
                helper.removeLast();
            }
            helper.addLast(i);
        }

        // Handling another window

        for (; i < arr.length; i++) {
            // Add the answer in res queue
            res.add(arr[helper.peekFirst()]);

            // removing that element that is not form current window

            while (!helper.isEmpty() && helper.peekFirst() <= i-k) {
                helper.removeFirst();
            }

            while (!helper.isEmpty() && arr[i] > arr[helper.peekLast()]) {
                helper.removeLast();
            }
            helper.addLast(i);

        }
        // lasyt walle ka answer adding in res queue
        res.add(arr[helper.peekFirst()]);

        System.out.println(res);

    }

    public static void main(String[] args) {
//        printBinary(5);
        int [] arr = { 1, 2, 3 ,1 ,4,5,2,3,6};
        SlidingWindowProblem(arr,3);


    }
}
