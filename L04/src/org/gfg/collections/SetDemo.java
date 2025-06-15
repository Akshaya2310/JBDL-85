package org.gfg.collections;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {


        //Set<Integer> set = new HashSet<>();
        //Set<Integer> set = new LinkedHashSet<>();
        //Set<Integer> set = new TreeSet<>();
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        set.add(12);
        set.add(100);
        set.add(14);
        set.add(12);
        set.add(15);

        System.out.println(set.size());
        System.out.println(set);


    }
}
