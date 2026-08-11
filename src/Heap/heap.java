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

    public static void heapSort( int [] arr){
        // calling heapify for the non-leaf nodes
        int n = arr.length;
        for(int i = (int) (Math.floor(n/2)-1); i >= 0 ; i--){
            heapify( i , n , arr);
        }

        // Swaping walla part
        for( int i = n-1 ; i > 0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0 , i , arr);
        }
    }

    public static void heapify(int i , int size , int [] arr){
        // i --> root (jispr heapify call huya hai )
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i ;

        if( left < size && arr[max] < arr[left]){
            max = left;
        }

        if( right < size && arr[max] < arr[right]){
            max = right;
        }

        // Swaping min and i (current)
        if(max != i){
            int temp =  arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            heapify(max , size , arr);
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
