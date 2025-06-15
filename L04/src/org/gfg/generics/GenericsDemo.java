package org.gfg.generics;


import org.gfg.collections.Person;
import org.gfg.collections.Student;

import java.util.*;

public class GenericsDemo {

    public static void main(String[] args) {
        Box box = new Box();
        box.put(1234);
        box.put("asdf");
        box.put(new Box());

        TypeSafeBox<String> typeSafeBox = new TypeSafeBox<>();
        typeSafeBox.put("qwert");
        //typeSafeBox.put(2134);


        TypeSafeBox<Integer> typeSafeBoxInt = new TypeSafeBox<>();
        typeSafeBoxInt.put(12345);

        TypeSafeBox<Object> objectTypeSafeBox = new TypeSafeBox<>();
        objectTypeSafeBox.put(1234);
        objectTypeSafeBox.put("1234");
        objectTypeSafeBox.put(new Box());

        Map<Student, Person> map = new HashMap<>();
        Map<String,Long> longMap = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        Collections.sort(list);

        List<Person> personList = new ArrayList<>();
        Collections.sort(personList);

        TollProcessor tollProcessor = new TollProcessor();
        Car car1 = new Car();
        tollProcessor.processToll(car1);

    }

}
