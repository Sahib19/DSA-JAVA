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

            while(currIdx > 0 && list.get(parentIdx) > list.get(currIdx) ){
                // swap both places
                int temp = list.get(currIdx);
                list.set(currIdx , list.get(parentIdx));
                list.set(parentIdx , temp);

                currIdx = parentIdx;
                parentIdx = (currIdx-1)/2;
            }
        }

        public int remove(){
            if(list.isEmpty()){
                System.out.println("Heap is Empty");
                return -1;
            }
            int data = list.getFirst();

            // swap last with first
            list.set(0 , list.getLast());
            list.set(list.size()-1 , data);

            // removing the last
            list.removeLast();

            heapify(0);
            return data;
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int min = i ;

            // tenno me se min ko dundo

            if(left < list.size() && list.get(min) > list.get(left)){
                min = left ;
            }
            if(right < list.size() && list.get(min) > list.get(right)){
                min = right;
            }

            // swap min with current idx that is root

            if( min != i){
                int temp =  list.get(min);
                list.set(min , list.get(i));
                list.set(i , temp);

                heapify(min);
            }
        }
    }


    public static void main(String [] args){
        heapDs heap = new heapDs();
        heap.add(5);
        heap.add(8);
        heap.add(2);
        heap.add(0);
        System.out.println(heapDs.list);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

    }
}
