package org.gfg.expdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDemo {


    public static void main(String[] args) {
        System.out.println("Executing main method");
        normalMethod();
    }

    //StackOverflowError
    private static void normalMethod(){
        System.out.println("Executing normal method");
        normalMethod();
    }

    //HeapOutOfMemory
    private static void heapOutOfMemoryDemo(){
        List<Date> dateList = new ArrayList<>();
        while (true){
            Date date = new Date();
            dateList.add(date);
        }
    }
}



