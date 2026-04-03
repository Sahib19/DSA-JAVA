package Revision;

public class revision {
    public static int cv(String str) {
        String vowels = "aieou";
        int count = 0 ;
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String str = "Sahieoub";
        System.out.print(cv(str));

    }
}
