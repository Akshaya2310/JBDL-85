package org.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<List<Person>> supplyPersonList = () -> {
            /*

             */
           List<Person> personList = new ArrayList<>();
           personList.add(new Person(13,"Rahul"));
            personList.add(new Person(33,"Ajay"));
            return personList;
        } ;

        Supplier<Double> randomValue = ()->Math.random();


        System.out.println(supplyPersonList.get());
    }
}
