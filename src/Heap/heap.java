package Heap;
import java.util.*;
class Student implements Comparable<Student> {
    int age;
    String name;

    Student( String name , int age){
        this.name = name ;
        this.age = age ;
    }

    public int compareTo(Student s2){
        return s2.age- this.age ;
    }
}
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

        public int remove(){ // remove ki O(1) + heapify ki O(log n)
            if(list.isEmpty()){
                System.out.println("Your heap is Empty Bro");
                return -1;
            }

            int data = list.get(0);

            //Swapping first with last
            int temp = list.get(list.size()-1);
            list.set(list.size()-1,list.get(0));
            list.set(0,temp);

            list.remove(list.size()-1);

            // tree of thik krne ke liye heapify ko call for root index
            heapify(0);
            return data;
        }

        public void heapify(int i ){
            int left = 2*i+1;
            int right = 2*i+2;

            int min = i ;

            if(left < list.size() && list.get(min) > list.get(left)){
                min = left;
            }

            if(right < list.size() && list.get(min) > list.get(right)){
                min = right ;
            }

            if(min != i ){
                // enn tenno me jo bhi min nikla hoga usko root se swap krdo
                int temp = list.get(i);
                list.set(i , list.get(min));
                list.set(min , temp);

                heapify(min);
            }
        }


//        public int remove(){
//            if(list.isEmpty()){
//                System.out.println("Heap is Empty");
//                return -1;
//            }
//            int data = list.getFirst();
//
//            // swap last with first
//            list.set(0 , list.getLast());
//            list.set(list.size()-1 , data);
//
//            // removing the last
//            list.removeLast();
//
//            heapify(0);
//            return data;
//        }
//
//        public void heapify(int i){
//            int left = 2*i+1;
//            int right = 2*i+2;
//            int min = i ;
//
//            // tenno me se min ko dundo
//
//            if(left < list.size() && list.get(min) > list.get(left)){
//                min = left ;
//            }
//            if(right < list.size() && list.get(min) > list.get(right)){
//                min = right;
//            }
//
//            // swap min with current idx that is root
//
//            if( min != i){
//                int temp =  list.get(min);
//                list.set(min , list.get(i));
//                list.set(i , temp);
//
//                heapify(min);
//            }
//        }
    }

    // heap sort + heapify code heapsort oriented
    public void heapsort(int [] arr){
        // no need to return anything as we do change in direct array
        int n = arr.length;

        // first making max heap from simple arr by calling heapify function for non - leaf nodes
        for( int i = (int) Math.floor(n/2)-1 ; i >= 0 ; i--){
            heapify(i , n , arr);
        }

        // swapping walla part
        for( int i = n-1 ; i > 0 ; i--){
            int temp = arr[0];
            arr[0] = arr [i];
            arr[i] = temp ; // the max elemnt goes to last now fix the remainig tree and no need to touch the exsting tree

            heapify(0,i,arr);
        }
    }

    public void heapify(int i , int size , int[] arr){
        // i hai jis index ke liye call kiya hia heapify ko
        int left = 2*i+1;
        int right = 2*i+2;

        int max = i ;

        if(left < size && arr[left] > arr[max]){
            max=left;
        }

        if( right < size && arr[right] > arr[max]){
            max=right;
        }

        if(max !=i){
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            heapify(max,size,arr);
        }
    }


    public static void main(String [] args){
        PriorityQueue <Student > pq = new PriorityQueue<>();
        pq.add(new Student ("Sahib" , 22));
        pq.add(new Student ("Arun" , 20));
        pq.add(new Student ("Khattar" , 26));

        while(!pq.isEmpty()){
            System.out.println(pq.remove().name);
        }


    }
}
