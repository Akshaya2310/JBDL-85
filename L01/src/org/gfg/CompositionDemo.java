package org.gfg;

public class CompositionDemo {

    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        System.out.println(l1);

        OS os = new OS("Windows");
        Keyboad k1 = new Keyboad();
        Laptop l2 = new Laptop("SK Laptop",os,k1);
        System.out.println(l2);

        OS os3 = new OS("MacOS");
        Keyboad k3 = new Keyboad();
        Laptop l3 = new Laptop("Rahul's Laptop",os,k3);
        System.out.println(l3);
    }
}
