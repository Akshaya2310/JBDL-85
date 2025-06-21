package org.gfg.threads;

public class MyTask implements Runnable {
    public void run(){
        System.out.println("MyTask running in:"+Thread.currentThread().getName());
    }
}

