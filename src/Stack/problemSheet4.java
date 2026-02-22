package Stack;
import java.util.Stack;

public class problemSheet4 {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        int len = path.length();
        int i = 0;

        while (i < len) {

            // 1️⃣ Skip multiple '/'
            while (i < len && path.charAt(i) == '/') {
                i++;
            }

            // 2️⃣ Extract directory name
            String dir = "";

            while (i < len && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;
            }

            // 3️⃣ Process directory
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(dir);
            }
        }

        // 4️⃣ Build final result
        StringBuilder sb = new StringBuilder();

        for (String s : stack) {
            sb.append("/").append(s);
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args){
        String str="//home///user/docs/../document";
       System.out.println( simplifyPath(str));
    }
}
