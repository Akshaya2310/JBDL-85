package org.gfg;

public interface IndGovtNorm {

    public void indiaSpecificFunction();

    void method1();

    default String getDeviceLocation(){
        return "Not Supported in IndGovtNorm";
    }
}
