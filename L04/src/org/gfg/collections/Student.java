package org.gfg.collections;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String Name;

    private Integer rollNo;

    private Integer marks;

    public Student(String name, Integer rollNo, Integer marks) {
        Name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public Student(String name, Integer rollNo) {
        Name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(rollNo, student.rollNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rollNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return rollNo.compareTo(rollNo);
    }
}
