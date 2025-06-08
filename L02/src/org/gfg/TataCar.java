package org.gfg;

public abstract class TataCar implements IndGovtMotorNorm {

    private Engine engine;

    public TataCar(Engine engine) {
        this.engine = engine;
    }

    public void tataSpecificMethod(){
        System.out.println("tataSpecificMethod");
    }

    public abstract void startCar();

    public abstract void stopCar();
}
