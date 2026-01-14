package Strings;

public class shortestPath {
    public static void ShortestPath(String route){
        int x=0 ,y =0;
        for(int i =0 ; i < route.length() ; i++){
            char character = route.charAt(i);
            if(character == 'n' || character == 'N'){
                y++;
            }else if(character == 's' || character == 'S'){
               y--;
            }else if(character == 'e' || character == 'E'){
                x++;
            }else if(character == 'w' || character == 'W'){
                x--;
            }
        }

        double shortestPath = Math.sqrt(
                Math.pow(x - 0, 2) + Math.pow(y - 0, 2)
        );

        System.out.println(" Shortest Distance = " + shortestPath);
    }

    public static void subString(String str , int st , int ed){
        StringBuilder subString = new StringBuilder();
        for(int i = st ; i< ed ; i++){
            subString.append(str.charAt(i));
        }
        String sub = subString.toString();
        System.out.println(sub);

    }

    public static void compareString(String [] arr ){
        // here we compare two string in lexicographical order
        String largest = arr[0];
        for(int i  =0 ; i<arr.length ; i++){
            if(largest.compareTo(arr[i])<0){
                largest = arr[i];
            }
        }
        System.out.println("The largest String according to Lexicographical order is "+largest);
    }

    public static void toUpperCase1(String str){
        // Charcter.toupperCase({String})
        // drawbak -> if white spaces ar even then after white spaes the word will not get capatilizes
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i =1 ; i <str.length() ; i++){
            if(str.charAt(i) == ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));

            }else{
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }

    public static void toUpperCase(String str){
        // Charcter.toupperCase({String})
        // drawbak -> if white spaces ar even then after white spaes the word will not get capatilizes
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
         boolean flag = false ;
        for(int i =1 ; i <str.length() ; i++){
            if(str.charAt(i) == ' '){
                flag = true;
                sb.append(str.charAt(i));
            }else{
                if(flag){
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    flag = false;
                }else{
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }

    // my below code is perfect but i made a little messy by covering the last condition also in the loop
    // So to fix it i am wiring one more code that fix it
    // very smartly
    public static void stringCompression1(String str){
        Integer counter =1 ;
        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i< str.length() ; i++){
            if(str.charAt(i) == str.charAt(i-1)){
               if(i == str.length()-1){
                   sb.append(str.charAt(i));
                   counter++;
                   if(counter>1)
                      sb.append(counter.toString());
               }else{
                   counter++;
               }
            }else{
                if(i == str.length()-1){
                    sb.append(str.charAt(i - 1));
                    if (counter > 1)
                        sb.append(counter.toString());
                    sb.append(str.charAt(i));
                }else {
                    sb.append(str.charAt(i - 1));
                    if (counter > 1)
                        sb.append(counter.toString());
                    counter = 1;
                }
            }
        }
        System.out.println(sb);
    }

    public static void stringCompression(String str) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                counter++;
            } else {
                sb.append(str.charAt(i - 1));
                if (counter > 1)
                    sb.append(counter);
                counter = 1;
            }
        }

        // handle last character/group
        sb.append(str.charAt(str.length() - 1));
        if (counter > 1)
            sb.append(counter);

        System.out.println(sb);
    }

    public static void main(String [] args){
//        String route = "WNEENESENNN";
//        ShortestPath(route);
//         subString("helloworld" , 0 ,5);
//        String [] fruits = {"apple","banana","kiwi","zalaka"};
//        compareString(fruits);
//        toUpperCase("Hello");

        stringCompression("aa");
    }
}
