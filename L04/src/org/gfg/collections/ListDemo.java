package org.gfg.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        //List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList = new LinkedList<>();
        integerList.add(11);
        integerList.add(12);
        integerList.add(13);
        integerList.add(11);
        System.out.println(integerList.get(1));

        System.out.println(integerList);


    }
}
