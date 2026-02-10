package ArrayList;
import java.util.*;

public class arrayList {

    public static void Swap(ArrayList<Integer> list ,  int idx1 , int idx2){
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
    }
    public static void main(String [] args) {
        int max =Integer.MAX_VALUE;
        ArrayList <Integer> list = new ArrayList<>();
        list.add(5);  // 0
        list.add(10); // 1
        list.add(11); // 2
        list.add(16); // 3
        list.add(19); // 4
        System.out.println(list);
//        for(int i =0 ;  i< list.size() ; i++){
//            System.out.print(list.get(i)+" ");
//        }

        Swap(list,2,4);
        System.out.println(list);

    }
}
