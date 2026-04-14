package Linked_List;
import java.util.*;

public class Problems {
    public static String reverseString(String str , Stack <Character> st ){
        if(str.isEmpty()){
            return "";
        }

        char curr = str.charAt(0);
        st.push(curr);
        return reverseString(str.substring(1) , st) + st.pop();
    }
    public static void main(String[] args) {
        Stack <Character> st = new Stack <>();
        System.out.println(reverseString("sahib" ,st));




    }
}
