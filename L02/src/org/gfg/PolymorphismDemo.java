package org.gfg;

import java.util.Scanner;

public class PolymorphismDemo {

    public static void main(String[] args) {

        //Compile Time Polymorphism; Static Binding
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println(areaCalculator.area(2.0));
        System.out.println(areaCalculator.area(2.0,5.0));


        //RunTime Polymorphism; Dynamic Binding
        System.out.println("Enter a letter");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        OS os = null;
        if(str.equals("u")){
            os = new Ubuntu();
        }
        else{
            os = new Windows();
        }
        os.manageCPU();

        //os.manageFileBaseIO();
        //How to access ubuntu specifc method
        if(os instanceof Ubuntu){
            Ubuntu ubuntu = (Ubuntu)os;
            ubuntu.manageFileBaseIO();
        }


    }
}
