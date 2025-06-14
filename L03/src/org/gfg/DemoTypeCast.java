package org.gfg;

import java.util.Date;

public class DemoTypeCast {

    public static void main(String[] args) {


        Object object = new Student("Rahul",new Date());
        Student student = (Student) object;
        System.out.println(student.getName());



        Object object2 = new Object();
        Student student2 = (Student) object2;
        System.out.println(student2.getName());




    }
}
class Student{

    private String name;
    private Date dob;

    public Student(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}