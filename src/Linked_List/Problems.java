package Linked_List;

import java.util.*;

public class Problems {

    public static void simplyfyPath(String str) {
        Stack<String> st = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            // skipping the '/'
            while (i < str.length() && str.charAt(i) == '/') {
                i++;
            }

            // now extracting the main thing
            while (i < str.length() && str.charAt(i) != '/') {
                sb.append(str.charAt(i));
                i++;
            }

            String res = sb.toString();
            sb.setLength(0);

            if (res.isEmpty() || res.equals(".")) {
                continue;
            } else if (res.equals("..")) {
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(res);
            }
        }

        sb.setLength(0);
        for (String s : st) {
            sb.append('/').append(s);
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        simplyfyPath("/home/user/../docs");
    }
}
