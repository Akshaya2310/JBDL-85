package org.gfg.collections;

import java.util.HashSet;
import java.util.Set;

public class EqualHashcodeDemo {


    public static void main(String[] args) {


        Set<Student> studentSet = new HashSet<>();

        Student student1 = new Student("Rahul",1,300);
        Student student2 = new Student("Rahul",1,300);

        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());



        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(new Student("Amit",2,300));

        System.out.println(studentSet.size());


    }
}
