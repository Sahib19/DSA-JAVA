package Queue;
import java.util.*;
import java.util.Queue;

public class ProblemsOnOueue {

    // O(N)
    public static void NonrepeatingChar(String str){
        Queue<Character> q1 = new LinkedList <>();
        int [] freq = new int [26];


        for( int i = 0 ; i< str.length() ; i++){
            char ch  =  str.charAt(i);
            // Incrementing this char in freq array
             freq[ch - 'a']++;
             q1.add(ch);
             while(!q1.isEmpty() && freq[q1.peek() - 'a'] > 1 ){
                    q1.remove();
             }
             if(q1.isEmpty()){
                 System.out.print(-1+" ");
             }else{
                 System.out.print(q1.peek()+" ");

             }

        }
    }

    public static void main(String [] args){
        NonrepeatingChar("aabccxb");
    }
}
