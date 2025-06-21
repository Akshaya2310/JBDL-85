package org.gfg.threads;

public class MyThread extends Thread {
    public void run(){
        System.out.println("MyThread running in: "+Thread.currentThread().getName());
    }
}

