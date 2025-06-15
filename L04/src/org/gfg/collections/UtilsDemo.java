package org.gfg.collections;

import java.util.*;

public class UtilsDemo {

    public static void main(String[] args) {
        Integer [] arr = {34,23,56,78};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));


//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(234);
//        integerList.add(234);

        //List<Integer> integerList = Arrays.asList(23,66,1,3);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(45);

        Collections.sort(integerList);
        System.out.println(integerList);

        Set<Integer> set = new HashSet<>();
        set.add(34);
        set.add(44);
        integerList.addAll(set);
        System.out.println(integerList);


        Student student1 = new Student("Amit",5,300);
        Student student2 = new Student("Rahul",1,300);
        Student student3 = new Student("Vivek",10,300);
        Student student4 = new Student("Binit",12,300);
        List<Student> students = Arrays.asList(student1,student2,student3, student4);
        System.out.println(students);
        Collections.sort(students);
        System.out.println("Sorted by Roll Number");
        System.out.println(students);
        int i = Collections.binarySearch(students,student1);
        System.out.println("index:"+i);
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(students, (o1,o2)-> o1.getName().compareTo(o2.getName()));

        System.out.println("Sorted by name");
        System.out.println(students);

    }
}
