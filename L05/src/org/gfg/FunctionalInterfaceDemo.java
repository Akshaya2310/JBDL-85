package org.gfg;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Check<Integer> checkEven = (x) -> x%2==0;

        Check<Integer> checkOdd = (x) -> x%2==1;

        Integer num = 18;

        System.out.println(checkEven.check(num));


        Check<Person> checkVoterElegibility = (p) -> p.age >=18;
    }
}


interface Check<T>{
    boolean check(T t);
}

class Person{

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int age;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}