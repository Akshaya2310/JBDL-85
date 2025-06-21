package org.gfg.threads;

public class MultiThreadingDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("1.Hello!");
        System.out.println("2.Hello!");

        Thread thread1 = new Thread(
                ()-> System.out.println("4.1.Hello! :"+Thread.currentThread().getName())
        );
        thread1.setName("My-Thread-1");
        thread1.start();

        System.out.println("3.Hello!");

        thread1.join();

        System.out.println("4.2.Hello!");
        System.out.println("5.Hello! :"+Thread.currentThread().getName());

    }
}
