package Revision;

public class Revision2 {
    public static void subset( String main , String helper , int idx){
        if( idx == main.length()){
            System.out.println(helper);
            return;
        }

        char ch = main.charAt(idx);
        subset(main , helper+ch , idx+1);
        subset(main , helper , idx+1);
    }

    public static void main(String[] args) {
        subset("abc" , "" , 0);
        System.out.println("abc".length());

    }
}
