package org.gfg;

import java.util.Date;

public class ImmutabilityDemo {

    public static void main(String[] args) {
        Date date = new Date();
        Student student = new Student("Rahul",date);
        System.out.println(student);
        date.setTime(1234567l);
        Date dob = student.getDob();
        dob.setTime(234567l);
        String name = student.getName();
        name="Amit";
        System.out.println(student);
    }

}

final class  Student{
    final private String name;
    final private Date dob;
    public Student(String name, Date dob) {
        this.name = name;
        this.dob = new Date(dob.getTime());
    }
    public String getName() {
        return name;
    }
    public Date getDob() {
        return new Date(dob.getTime());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}