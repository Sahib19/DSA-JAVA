package Revision;

import java.util.*;

public class QueueRv {
    public static void main(String [] args){
        Queue <Integer> q1 = new ArrayDeque(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Queue  <Integer> q2 = new ArrayDeque();

        int len = q1.size()/2;
       while(q1.size() != len){
           q2.add(q1.remove());
       }
        System.out.println(q2);

        while(!q2.isEmpty()){
           q1.add(q2.remove());
           q1.add(q1.remove());
       }

       System.out.println(q1);


    }
}
