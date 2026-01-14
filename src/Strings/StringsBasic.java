package Strings;

public class StringsBasic {

    //checking if string is palindrome or not
    public static boolean isPalindrome(String str){
        // O(n)
        for(int i =0 ; i < str.length()/2 ; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }

        //
        String reverse ="";
        for(int i  = str.length()-1 ; i>=0 ; i--){
            reverse += str.charAt(i);
        }
        if(!str.equals(reverse))
            return false;
        return true;
    }
    public static void main(String[] args){
//        String name = new String("Sahib");
//        String name = "Sahib";
//        for(int  i=0 ; i< name.length() ; i++){
//            System.out.println(name.charAt(i));

        System.out.println(isPalindrome("aspsaa"));;


        }
    }
