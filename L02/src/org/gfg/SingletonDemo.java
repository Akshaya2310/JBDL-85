package org.gfg;

public class SingletonDemo {

    public static void main(String[] args) {

        Principal p1 = Principal.getINSTANCE();
        Principal p2 = Principal.getINSTANCE();

        System.out.println(p1==p2);

    }
}
