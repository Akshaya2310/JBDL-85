package org.gfg;

public class Student extends Person {
    private Integer regNum;
    String batch;
    protected String certificate;

    public Student(Integer regNum, String name) {
        this.regNum = regNum;
        this.name = name.toLowerCase();
    }

    public Integer getRegNum() {
        return regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        /*

         */
        this.name = name;
    }

    public void study(){
        System.out.println(name+" is studying");
    }

    @Override
    public String toString() {
        return "Student{" +
                ", batch='" + batch + '\'' +
                ", certificate='" + certificate + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public void walk(){
        System.out.println("Student "+name+" is walking");
    }

//    @Override
//    private void sleep(){
//        System.out.println("Person "+name+" is sleeping");
//    }
}
