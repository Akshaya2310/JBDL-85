package org.gfg.expdemo;

public class ProductNotFoundException extends Exception {
    private String id;

    public ProductNotFoundException(String id, String msg) {
        super(msg);
        this.id = id;
    }


}
