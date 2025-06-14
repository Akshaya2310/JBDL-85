package org.gfg.collections;

public class TypeSafeBox<T> {

    private T t;

    public void put(T t){
        this.t =t;
    }

    public T get(){
        return t;
    }
}
