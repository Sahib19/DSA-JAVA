package Revision;

public class revision {
    public static String sc(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1 ;
        for( int i = 1 ; i < str.length() ; i++){
            char curr = str.charAt(i);
            if(curr == str.charAt(i-1)){
                count++;
            }else{
                sb.append(str.charAt(i-1));
                if(count > 1){
                    sb.append(count);
                }
                count =1;
            }
        }

        // exlpicitly handling the last one
        sb.append(str.charAt(str.length()-1));
        if(count >1){
            sb.append(count);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "aaabbbccdd";
        System.out.println(str.indexOf('z'));


    }
}
