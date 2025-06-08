package org.gfg;

//public class Laptop implements IndGovtNorm, IndiaITDeptNorm {
public class Laptop implements IndianElectronicDeviceInterface {

    private String name;
    private OS os;

    public Laptop(String name, OS os) {
        this.name = name;
        this.os = os;
    }

    @Override
    public void indiaSpecificFunction() {

    }

    @Override
    public void method1() {
        System.out.println("Method1 in Laptop");
    }

    @Override
    public String getDeviceLocation() {
        return "Laptop location";
    }

    @Override
    public void indiaITDepSpecificFunction() {

    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", os=" + os +
                '}';
    }
}
