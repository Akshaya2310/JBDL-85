package org.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(2,4,5,7,8,10);

        List<String> stringList = Arrays.asList("abc","weer","pop","xyz","abc","weer","pop","xyz","abc","weer","pop","xyz","abc","weer","pop","xyz","abc","weer","pop","xyz");

        for(String str: stringList){
            System.out.println(str+":"+str.length());
        }

        Consumer<String> printLen = (str) -> { System.out.println(str+":"+str.length());
            System.out.println(Thread.currentThread().getName());
        };
        stringList.forEach(printLen);

        Predicate<Integer> checkEven = (x) -> x%2 ==0;
        Function<Integer,Integer> sqFunc = (x) -> x*x;

        long evenCount = integerList.stream().filter(checkEven).count();
        System.out.println(evenCount);

        List<Integer> even = integerList.stream().filter(checkEven).toList();
        System.out.println(even);

        Stream<Integer> integerStream = integerList.stream().filter(checkEven).map(sqFunc);
        /*
        10 line;
         */
        List<Integer> evenSq = integerStream.toList();
        System.out.println(evenSq);


        List<Integer> sqList = new ArrayList<>();
        for(Integer num : integerList){
            if(num%2==0){
                sqList.add(num*num);
            }
        }



        stringList.parallelStream().forEach(printLen);
    }
}
