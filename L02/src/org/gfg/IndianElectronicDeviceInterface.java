package org.gfg;

public interface IndianElectronicDeviceInterface extends IndGovtNorm, IndiaITDeptNorm {
    @Override
    default String getDeviceLocation() {
        return "Default loc";
    }
}
