package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemSheet {
    public static void countVowels(String str){
        int count = 0 ;
        char ch ;
    for(int i=0 ; i<str.length() ; i++){
        ch = str.charAt(i);
         if(ch == 'a' ||ch == 'i' ||ch == 'e' ||ch == 'o' ||ch == 'u')
             count++;

      }
        System.out.println("Number of vowels present are "+count);
    }

//    public static void anagrams1(String str1 ,String str2 ){
//        int sum1 =0  , sum2 =0  ;
//        String strr1 = str1.toLowerCase();
//        String strr2 = str2.toLowerCase();
//            for (int i = 0; i < strr1.length(); i++) {
//                sum1 += strr1.charAt(i);
//            }
//            for (int i = 0; i < strr2.length(); i++) {
//                sum2 += strr2.charAt(i);
//            }
//
//            if(sum1 == sum2 ){
//                System.out.println("Dono strings anagrams hai");
//            }else{
//                System.out.println("Nhi hai Anagram");
//            }
//    }

    public static void anagrams(String string1 ,String string2 ){
        String str1 = string1.toLowerCase();
        String str2 = string2.toLowerCase();

        char [] str1charArray = str1.toCharArray();
        char [] str2charArray = str2.toCharArray();

        Arrays.sort(str1charArray);
        Arrays.sort(str2charArray);

        if(Arrays.equals(str1charArray,str2charArray)){
            System.out.println("Both strings are anagrams");
        }else{
            System.out.println("Not anagrams");
        }

    }
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your String ");
//        String str = sc.nextLine();
//        countVowels(str);
        anagrams("bc","cb.");

    }
}
