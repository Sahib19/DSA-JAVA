package Revision;

import java.util.*;

public class Revision2 {

    public static String ntos(int num, String [] map) {
        if (num == 0) {
            return "";
        }
        String res = ntos(num/10 , map );
        int last = num % 10;
        return res+map[last]+" ";
    }

    public static void main(String[] args) {
        String[] map = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };
        StringBuilder sb = new StringBuilder();
        System.out.println(ntos(3024654,map));


    }
}
