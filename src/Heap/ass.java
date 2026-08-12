package Heap;
import java.util.*;

public class ass {
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        double dist;

        Point( int x , int y ){
            this.x = x;
            this.y = y;
            // its distance from origin will be
            this.dist = Math.sqrt((x*x) + (y*y));
        }

        public int compareTo(Point p2){
            return (int) ((int) this.dist - p2.dist);
        }

    }

    public static void N_Near_Cars(int [][] cars , int k ){
        PriorityQueue <Point> pq = new PriorityQueue<>();
        for(int [] arr : cars){
            pq.add(new Point(arr[0] , arr[1]));
        }

        for( int i = 0 ; i < k ; i++){
            System.out.println("{ " + pq.peek().x + " , " +pq.peek().y +" }");
            pq.remove();
        }
    }

    public static int fillNSlots(int[] arr , int n) {
//        n -> numbers of slots start from zero
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        for(int ele : arr){
           for( int i = 1 ; i <= n ; i++ ){
               if(ele != i){
                   int minDist = Math.abs(ele-i);
                   pq.add(minDist);
               }
           }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        // Fill n slots
        int[][] cars = {
                {1, 2},
                {3, 4},
                {5, 6},
                {-1, 2},
                {2, -3}
        };
        N_Near_Cars(cars,3);



    }
}
