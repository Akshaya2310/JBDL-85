package org.gfg;

import com.payment.ClassMonitor;

public class InheritanceDemo {


    public static void main(String[] args) {

        Student s1 = new Student(123,"Rakesh");
//        System.out.println(student);
        s1.study();
        Person p1 = new Person();
        p1.name ="Pawan";

        p1.walk();
        s1.walk();

        ClassMonitor cm1 = new ClassMonitor(12,"Rahul");
        cm1.walk();

        //
        Person p = new Student(3,"Hitesh");
        p.walk();
        //p.study();
        Student s2 = (Student)p;
        s2.study();

        //
        //Student s3 = new Person();
        Student s3 = new Student(76,"Priya");
        s3.study();
        Person p3 = (Person) s3;
        p3.walk();
//        p3.study();




//        RegVehicle regVehicle1 = new Bike();
//        processFastag(regVehicle1);
//
//        Car car = new Car();
//        processFastag(car);


    }

     static void processFastag(RegVehicle vehicle){
        String fastagData = vehicle.getFastagDetails();
        /*

         */
    }
}

class RegVehicle{
    public String getFastagDetails(){
        return "";
    }
}
class Bike extends RegVehicle{

}
class Car extends RegVehicle{
    void drive4wheel(){

    }
}