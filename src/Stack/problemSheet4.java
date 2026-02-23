package Stack;
import java.util.Stack;

public class problemSheet4 {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        int len = path.length();
        int i = 0;
        StringBuilder dir = new StringBuilder();
        while (i < len) {
            dir.setLength(0);  // clears the content

            // 1️⃣ Skip multiple '/'
            while (i < len && path.charAt(i) == '/') {
                i++;
            }

            // 2️⃣ Extract directory name

            while (i < len && path.charAt(i) != '/') {
                dir.append(path.charAt(i));
                i++;
            }

            String res = dir.toString();

            // 3️⃣ Process directory
            if (res.equals("") || res.equals(".")) {
                continue;
            }
            else if (res.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(res);
            }
        }

        // 4️⃣ Build final result
        dir.setLength(0);  // clears the content

        for (String s : stack) {
            dir.append("/").append(s);
        }

        return dir.length() == 0 ? "/" : dir.toString();
    }

    public static String decodeString(String code){

        Stack <String> StringStack = new Stack<>();
        Stack <Integer> IntegerStack = new Stack<>();

        String curr = "";
        int num = 0 ;
        for( char ch : code.toCharArray()){
            // ya vo ye hai 'Digit hai  '
            if(Character.isDigit(ch)){ // it mean vo ek digit hai
                num = num * 10 + (ch - '0');
            }

            // ya vo ye hai '['
            else if(ch == '['){
                StringStack.push(curr);
                IntegerStack.push(num);
                curr = "";
                num=0;
            }

            // ya vo ye hai ']'
            else if (ch == ']'){
                int repeatTimes = IntegerStack.pop();
                String prev = StringStack.pop();

                StringBuilder temp = new StringBuilder();
                for(int i = 1 ; i <= repeatTimes ; i++){
                    temp.append(curr) ;
                }

                curr = prev+ temp.toString();
            }

            // ya vo ye hai 'Koi simple alphabet hai'
            else{
                curr += ch ;
            }

        }
        return curr;
    }

    public static void main(String[] args){
        String str="ab3[cc]";
       System.out.println( decodeString(str));
    }
}
