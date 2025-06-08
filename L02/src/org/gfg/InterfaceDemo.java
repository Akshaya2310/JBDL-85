package org.gfg;

import java.util.List;

public class InterfaceDemo {


    public static void main(String[] args) {
        Windows windows = new Windows();
        Ubuntu ubuntu = new Ubuntu();
        Laptop laptop1 = new Laptop("Dell 234",windows);

        Laptop laptop2 = new Laptop("Dell 34",ubuntu);

        laptop1.method1();

        laptop1.getDeviceLocation();

        //List

    }
}
