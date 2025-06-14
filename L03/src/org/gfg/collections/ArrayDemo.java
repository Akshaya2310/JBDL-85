package org.gfg.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        //arrayDemo();
        collectionDemo();
    }


    private static void collectionDemo(){
        List<String> students = new ArrayList<>();
        students.add("Ravi");
        students.add("Rahul");
        students.add("Ajay");
        System.out.println(students);
    }

    private static void arrayDemo() {
        String[] students = new String[2];
        students[0] = "Ravi";
        students[1] = "Rahul";
        System.out.println(students);
        printArray(students);

        String[] temp = new String[3];
        for(int i=0; i<students.length; i++){
            temp[i] = students[i];
        }
        temp[2] = "Ajay";
        students = temp;
        printArray(students);


//        students[2]="Ajay";
//        printArray(students);
    }

    private static void printArray(String[] students){
        for(String student: students){
            System.out.println(student);
        }
    }
}
