package Oops;
class ComplexNumber{
    int real ;
    int imag;
    ComplexNumber(int real , int imag){
        this.real = real ;
        this.imag =  imag;
    }

    public void printCN() {
        if (real == 0 && imag == 0) {
            System.out.println("0");
        } else if (imag == 0) {
            System.out.println(real);
        } else if (real == 0) {
            System.out.println(imag + "i");
        } else if (imag > 0) {
            System.out.println(real + "+" + imag + "i");
        } else {
            System.out.println(real + "" + imag + "i");
        }
    }


//    public void printCN(){
//            System.out.println(this.real +"+"+ this.imag + "i");
//    }

   public static ComplexNumber add(ComplexNumber c1 , ComplexNumber c2){
        return new ComplexNumber((c1.real+c2.real),(c1.imag+c2.imag));
   }

   public static ComplexNumber substract(ComplexNumber c1 , ComplexNumber c2){
       return new ComplexNumber((c1.real-c2.real),(c1.imag-c2.imag));
   }

    public static ComplexNumber multiply(ComplexNumber c1 , ComplexNumber c2){
        return new ComplexNumber((c1.real*c2.real)-(c1.imag*c2.imag)
                ,(c1.real*c2.imag)+(c1.imag*c2.real));
    }
}

public class OopsProblemSheet {
    public static void main(String[] args){
        ComplexNumber c1 = new ComplexNumber(3,2);
        c1.printCN();
        ComplexNumber c2 = new ComplexNumber(1,4);
        c2.printCN();

        ComplexNumber c3 = ComplexNumber.add(c1,c2);
        ComplexNumber c4 =ComplexNumber.substract(c1,c2);
        ComplexNumber c5 =ComplexNumber.multiply(c1,c2);

        System.out.println("The addition is ");
        c3.printCN();
        System.out.println("The substraction is ");
        c4.printCN();
        System.out.println("The multiplication is ");
        c5.printCN();

    }

}
