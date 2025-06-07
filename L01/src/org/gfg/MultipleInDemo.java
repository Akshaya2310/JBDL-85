package org.gfg;

public class MultipleInDemo {
    public static void main(String[] args) {
        C c = new C();
        c.method1();

        A a = new D();
        Object obj = new D();
        Object obj2 = new Laptop();
        obj2.toString();
        Laptop laptop = (Laptop) obj2;
        laptop.startLaptop();



    }
}


class A{

    public void method1(){
        System.out.println("Method1 of A");
    }
}

class B extends A{

    public void method1(){
        System.out.println("Method1 of B");
    }
}
class D extends B{
    public void method1(){
        System.out.println("Method1 of D");
        super.method1();
//        super.toString();
    }
}
class C extends D{

}