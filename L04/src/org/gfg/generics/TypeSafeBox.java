package org.gfg.generics;

public class TypeSafeBox<T> {

    private T t;

    public void put(T t){
        this.t =t;
    }

    public T get(){
        return t;
    }
}
