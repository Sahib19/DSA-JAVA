package Heap;
import java.util.ArrayList;

public class heap {
    public static class heapDs{
        static ArrayList <Integer> list = new ArrayList<>();

        public void add( int data){
            // MIN HEAP -> parent < children
            list.add(data); // element get added in the last

            int currIdx = list.size()-1;
            int parentIdx = (currIdx-1)/2;

            while(list.get(parentIdx) > list.get(currIdx) ){
                // swap both places
                int temp = list.get(currIdx);
                list.set(currIdx , list.get(parentIdx));
                list.set(parentIdx , temp);

                currIdx = parentIdx;
                parentIdx = (currIdx-1)/2;
            }
        }
    }
    public static void main(String [] args){
        heapDs heap = new heapDs();
        heap.add(5);
        heap.add(8);
        heap.add(2);
        heap.add(0);

    }
}
