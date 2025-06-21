package org.gfg;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> checkEven = (x) -> x%2==0;


        Predicate<Integer> divisibleBy3 = (x) -> x%3==0;

        Predicate<Integer> divisibleBy6 = checkEven.and(divisibleBy3);



        Integer num = 18;

        System.out.println(checkEven.test(num));

        System.out.println(divisibleBy6.test(num));

        System.out.println(checkEven.negate().test(num));

        Predicate<Person> checkVoterElegibility = (p) -> p.age >=18;
        Person p1 = new Person(19,"Ravi");

        System.out.println(checkVoterElegibility.test(p1));


    }
}
