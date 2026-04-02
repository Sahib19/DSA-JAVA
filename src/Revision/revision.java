package Revision;

import java.util.Arrays;

public class revision {
    public static void PrintSpiral(int [] [] arr){
       int sr = 0 ;
       int sc = 0 ;
       int er = arr.length-1;
       int ec = arr[0].length-1;
       System.out.println(er+" "+ec);

       while( sr <= er && sc <= ec){

           // Top row
           for(int i = sc ; i <= ec ; i++){
               System.out.print(arr[sr][i]+" ");
           }

           // right column
           for(int j =  sr+1 ; j <= er ; j++ ){
               System.out.print(arr[j][ec]+" ");
           }

           //bottom row
           for( int p = ec-1 ; p >= sc ; p-- ){
               if(sr == er) break ;
               System.out.print(arr[er][p]+" ");
           }

           // left column
           for( int q = er-1 ; q >= sr+1 ; q--){
               if(sc == ec) break;
               System.out.print(arr[q][sc]+" ");
           }

           sr++;
           sc++;
           er--;
           ec--;
       }
    }


    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3, 4}
                       };
        PrintSpiral(arr);



    }
}
