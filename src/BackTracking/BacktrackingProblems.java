package BackTracking;

public class BacktrackingProblems {
    //Printing subset for a string
    public static void printSubset(String main , String str , int idx){
        if(idx == main.length()){
            if(str.isEmpty()){
                System.out.print("Φ");
            }else {
                System.out.print(str + " ");
            }
            return;
        }
        char ch = main.charAt(idx);
        // character say yes
        printSubset(main ,str+ch , idx+1);
        // character say no
        printSubset(main , str , idx+1);
    }
    public static void main(String [] args){
     String str= "";
     String main= "abc";
     printSubset(main , str , 0);
    }
}
