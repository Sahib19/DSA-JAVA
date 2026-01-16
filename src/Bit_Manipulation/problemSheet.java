package Bit_Manipulation;

public class problemSheet {
    public static void UpperToLowerCase(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i< str.length() ; i++){
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch | ' '); // HERE WE CONVERT IT FORM UPPERcase to lower case
            }
            sb.append(ch);
        }
        sb.toString();
        System.out.println(sb);
    }



    public static void main(String [] args)
    {
//        UpperToLowerCase("HEL SDOI CNSCIOSC S34234NCVSD");
        // swaping two number
        int x =3 , y=5 ;
        x = x ^ y ;
        y = x ^ y ;
        x= x ^ y ;

        System.out.println("values after swaping x = "+x+" y = "+y);
    }}
