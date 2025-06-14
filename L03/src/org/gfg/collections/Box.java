package org.gfg.collections;

public class Box {
    private Object object;

    public void put(Object object){
        this.object = object;
    }

    public Object get(){
        return object;
    }
}
