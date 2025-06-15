package org.gfg.collections;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Calculator addition = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a+b;
            }
        };

        Calculator multiplication = (a, b) -> a*b;


        Calculator division = (a, b) -> a/b;

        //Calculator multiplication = (a,b) -> a*b;

        System.out.println(addition.calculate(2,6));
        System.out.println(multiplication.calculate(2,6));
    }
}
