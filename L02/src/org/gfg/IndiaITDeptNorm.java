package org.gfg;

public interface IndiaITDeptNorm {

    static String getDeptName(){
        return "";
    }


     public abstract void indiaITDepSpecificFunction();

    void method1();

    default String getDeviceLocation(){
        return "Not Supported IndiaITDeptNorm";
    }
}
