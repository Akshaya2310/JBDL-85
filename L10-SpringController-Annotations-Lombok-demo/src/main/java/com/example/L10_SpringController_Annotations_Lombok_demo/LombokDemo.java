package com.example.L10_SpringController_Annotations_Lombok_demo;

public class LombokDemo {
    public static void main(String[] args) {


        Person person = new Person(1l,20,"Rahul");
        System.out.println(person.getName());
        person.setName("Rahul");

        System.out.println(person);
    }
}
