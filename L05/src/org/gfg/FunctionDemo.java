package org.gfg;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {

        Function<Person,Student> register = (person -> {
            Student student = new Student(person.name,1,"CS");
            return student;
        });

        Person p1 = new Person(23,"Ravi");


        Function<Student,IdCard> issueCard = (student1 -> {
            IdCard card = new IdCard();
            return card;
        });

        IdCard card = register.andThen(issueCard).apply(p1);
    }
}

class IdCard{

}

class Student
{
    String name;
    int rollNo;
    String subject;

    public Student(String name, int rollNo, String subject) {
        this.name = name;
        this.rollNo = rollNo;
        this.subject = subject;
    }
}
