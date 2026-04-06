package Revision;

abstract class a {
    int data = 5 ;
    abstract void meth1();

    public void meth2(){
        System.out.println("hello");
    }
}

class b extends a{
    public void meth1(){
        System.out.println("lelo podina");
    }

}

public class revision {
    public static void main(String[] args) {
       a obj = new b();
       obj.meth2();
    }
}
