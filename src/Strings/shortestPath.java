package Strings;

public class shortestPath {
    public static void shortestPath(String route){
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
    public static void main(String [] args){
        String route = "WNEENESENNN";
        shortestPath(route);

    }
}
