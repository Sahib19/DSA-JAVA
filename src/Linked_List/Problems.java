package Linked_List;

import java.util.*;

public class Problems {

    public static int trp(int [] heights){
        Stack <Integer> st = new Stack <>();
        int water = 0 ;
        int bottom = 0;
        for( int i = 0 ; i < heights.length ; i++){
            int curr = heights[i];

            while(!st.isEmpty() && curr > heights[st.peek()]) {
                bottom = st.pop();
                if (st.isEmpty()) {
                    break;
                }


                int left = st.peek();
                int right = i;

                int width = right - left - 1;

                int height = Math.min(heights[left], heights[right]) - heights[bottom];

                water += width * height;

            }
            st.push(i);
        }

        return water;

    }
    public static void main(String []  args){
        // Trapping Rain Water Problem
        int [] level = {6,3,2,4};
        System.out.println(trp(level));


    }
}
