package org.gfg;

public class ClassObjectDemo {

    public static void main(String[] args) {

        System.out.println(Lecture.totalObjects);

        Lecture l1 = new Lecture("L01","Shashi","LIVE");
        System.out.println(l1.title);
        System.out.println(Lecture.totalObjects);
        Lecture l2 = new Lecture("L02","RAVI","UPCOMING");
        System.out.println(l2.title);
        System.out.println(Lecture.totalObjects);

        Person p1 = new Person();
        p1.name = "Rahul";
        System.out.println(p1.name);
        p1.name = "Ravi";

        System.out.println(l1.totalObjects);
        System.out.println(l2.totalObjects);
        l2.totalObjects =100;
        System.out.println(l1.totalObjects);
    }
}
