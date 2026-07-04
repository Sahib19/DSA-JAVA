package HashMap;

import java.util.*;

public class hashmap {

    public static void main(String[] args) {
        // Hashmap

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 4, 2};
        // union - 7,3,9,6,4,2
        // intersection - 3,9

        HashSet<Integer> set = new HashSet<>();

        for (int ele : arr1) {
            set.add(ele);
        }

        // for intersection
        for (int ele : arr2) {
            if (set.contains(ele)) {
                System.out.print(ele + " ");
            }
        }

        // for union
        for (int ele : arr2) {
            set.add(ele);
        }
        System.out.println(set);
        // both operation is in O(n+m) better than brute force O(n^2)

//-------------------------------------------------------------------------------------------


    }
}
