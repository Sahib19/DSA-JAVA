package Linked_List;

import java.util.*;

public class Problems {
    public static String multiply(String str , int num){
        String temp = "" ;
        for(int i = 1 ; i <= num ; i++){
            temp += str ;
        }
        return temp;
    }

    public static String decode(String str){
        Stack <Integer> numStack = new Stack <>();
        Stack <String> characterStack = new Stack <>();

        String curr = "";
        int num = 0;
        for(char ch : str.toCharArray()){

            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            }
            else if(ch == '['){
                numStack.push(num);
                characterStack.push(curr);
                num = 0 ;
                curr = "";
            }
            else if(ch == ']'){
                int times = numStack.pop();
                String prev = characterStack.pop();

                String res = multiply(curr ,times);
                System.out.println(res);
                System.out.println(prev);
                curr = prev + res ;

            }else{
                curr += ch ;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(decode("ab3[ca]"));
    }
}
