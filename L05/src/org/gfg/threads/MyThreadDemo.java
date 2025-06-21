package org.gfg.threads;

public class MyThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.setName("MyThread-01");
//        myThread.run();
        myThread.start();
        myThread.join();
        System.out.println("Done");


    }
}
