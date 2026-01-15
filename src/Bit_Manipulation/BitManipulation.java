package Bit_Manipulation;

public class BitManipulation {
    public static void OddEven(int num){
        int bitMask =1;
        if((num & bitMask) == 0){
            System.out.println("Even Number");
        } else if ((num & bitMask) == 1) {
            System.out.println("odd number");
        }else{
            System.out.println("unknown");
        }

    }

    public static void getIthBit(int num , int i ){
        int bitMask = 1<<i;
        if((num & bitMask) == 0){
            System.out.println("The ith bit is 0");
        }else{
            System.out.println("The ith bit is 1");
        }
    }

    public static int setIthBit(int num , int i ){
        int bitmask = 1<<i ;
        return num|bitmask ;
    }

    public static int clearIthBit(int num , int i ){
        int bitmask = ~(1<<i) ;
        return num & bitmask ;
    }

    public static void CountSetBit(int num){
        int count=0;
        while(num != 0 ){
            if((num & 1) ==1 ){
                count++;
            }
            num >>= 1 ;
        }
        System.out.println("the number of 1's are "+count);
    }
    public static void main (String[] args){
//        OddEven(-5987);
//    getIthBit(15,4);
//        System.out.println(setIthBit(10,2));;
//        System.out.println(clearIthBit(3,1));
        CountSetBit(16);


    }
}
