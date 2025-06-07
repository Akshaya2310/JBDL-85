package com.payment;

import org.gfg.Student;

public class ClassMonitor extends Student {
    public ClassMonitor(Integer regNum, String name) {
        super(regNum, name);
    }

    public void monitorClass(){

    }

    @Override
    public void walk(){
        System.out.println("ClassMonitor "+super.getName()+" is walking with certificate "+certificate);
        super.walk();
    }
}
