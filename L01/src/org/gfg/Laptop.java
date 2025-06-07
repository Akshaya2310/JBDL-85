package org.gfg;

public class Laptop {

    private String name;
    private OS os;
    private Keyboad keyboad;

    public Laptop() {
        this.name = "DELL E44";
        this.os = new OS("Ubuntu");
        this.keyboad = new Keyboad();
    }

    public Laptop(String name, OS os, Keyboad keyboad) {
        this.name = name;
        this.os = os;
        this.keyboad = keyboad;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", os=" + os +
                ", keyboad=" + keyboad +
                '}';
    }

    public void startLaptop(){

    }
}
