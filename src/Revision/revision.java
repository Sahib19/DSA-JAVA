package Revision;

public class revision {
    public static String tuc(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String tuc2(String str) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for( int i = 1 ; i < str.length() ; i++){
            char curr = str.charAt(i);
            if(curr == ' '){
                flag = true ;
                sb.append(curr);
            }else{
                if(flag){
                    sb.append(Character.toUpperCase(curr));
                    flag = false;
                }else{
                    sb.append(curr);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {



    }
}
