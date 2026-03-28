public class Main {

    public static void butterfly(int n) {
        // this is for first half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // this is for inverted half ( mirror image)
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // loop for spaces - n-i
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // loop for stars
            System.out.println("*****");
        }
    }

    public static void hollowInvertedRhombus(int n) {
        //outer loop
        for (int i = 1; i <= n; i++) {
//            hollow space -> iske bina apne pass hollow rectangle aa jaega -> ok bro
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            //boundary condition
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
/*
        rhombus(5);
        hollowInvertedRhombus(5);

*/
        butterfly(5);
    }
}