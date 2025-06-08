package org.gfg;

public class StaticDemo {

    public static Integer objCount;

    public StaticDemo() {
        objCount++;
    }

    public static void  method1(){
        System.out.println("Static method");
    }

    static
    {
        System.out.println("Executing static block");
    }

    public static void main(String[] args) {
        StaticDemo.objCount =0;
        StaticDemo.method1();

        StaticDemo staticDemo1 = new StaticDemo();
        System.out.println(staticDemo1.objCount);
        System.out.println(StaticDemo.objCount);
    }
}
