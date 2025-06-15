package org.gfg.collections;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {
//        Map<String, List<Integer>> cityPincodeMap = new HashMap<>();
//
//        String city = "New Delhi";
//        List<Integer> pincodes = new ArrayList<>();
//        pincodes.add(110071);
//        pincodes.add(110072);
//        cityPincodeMap.put(city,pincodes);



        Map<String,Student> studentMap = new HashMap();
        Student s1 = new Student("Rahul",1);
        Student s2 = new Student("Ravi",2);
        Student s3 = new Student("Rahul Kumar",1);
        Student s4 = new Student("Shashi",4);

        studentMap.put("Rahul",s1);
        studentMap.put("Ravi",s2);
        studentMap.put(null,s3);
        studentMap.put("shashi",null);
        System.out.println(studentMap.size());

        System.out.println(studentMap.get("Ravi"));
        System.out.println(studentMap.get(null));
        System.out.println(studentMap.get("shashi"));
        System.out.println(studentMap.get("vishnu"));


        System.out.println("Processing studentPersonMap:");
        Map<Student,Person> studentPersonMap = new HashMap<>();
        studentPersonMap.put(s1,new Person("Raghav"));
        studentPersonMap.put(s3,new Person("Rani"));

        System.out.println(s1.equals(s3));
        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(studentPersonMap.size());
        System.out.println(studentPersonMap.get(s1));
        System.out.println(studentPersonMap.get(s3));


    }

}
/*
aaa.asdf.sdf.method()

City-Pincode
Pincode-PostOffice()


 */