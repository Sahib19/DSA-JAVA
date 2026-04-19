package Linked_List;
import java.util.*;

public class Problems {
    public static void stockSpan (int [] stocks){
        Stack < Integer> st = new Stack<>();
        ArrayList <Integer> res = new ArrayList<>();
        res.add(1);
        st.push(0);

        for( int i = 1 ; i < stocks.length ; i++){
            int curr = stocks[i];
            while(!st.isEmpty() && stocks[st.peek()] <= curr ){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(i+1);
            }else {
                res.add(i - st.peek());
            }
            st.push(i);
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        Stack <Integer> st = new Stack <>();
        int [] stocks = {100,80,60,70,60,85,100};
        stockSpan(stocks);






    }
}
