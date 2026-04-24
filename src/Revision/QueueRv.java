package Revision;

import java.util.*;

public class QueueRv {

    public static void nrp( String str){
        int [] freq = new int [26] ; // 0 to 25
        Queue <Character> q1 = new ArrayDeque<>();
        for( int i = 0 ; i < str.length() ; i++){
            char curr = str.charAt(i);
            freq[curr-'a']++;
            q1.add(curr);
            while(!q1.isEmpty() && freq[q1.peek()-'a'] > 1){
                q1.remove(); // element get removed from the front
            }
            if(q1.isEmpty()){
                System.out.print("-1 " );
            }else{
                System.out.print(q1.peek()+" ");
            }
        }
    }
    public static void main(String [] args){
        nrp("aabccxb");
    }
}
