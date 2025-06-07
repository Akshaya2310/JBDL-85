package org.gfg;

public class EncapsulationDemo {

    public static void main(String[] args) {


        Student s1 = new Student(1,"Rahul");
        s1.setName("Rahul Singh");
        s1.batch="85";
        s1.certificate="";

        System.out.println(s1);

        Student s2 = new Student(2,"Ravi");
        System.out.println(s2);



    }
}
