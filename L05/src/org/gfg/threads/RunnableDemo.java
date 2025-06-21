package org.gfg.threads;

public class RunnableDemo {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        myTask.run();

        Thread thread1 = new Thread(myTask);
        thread1.setName("worker-01");
        thread1.start();




        Thread thread2 = new Thread(myTask);
        thread2.setName("worker-02");
        thread2.start();


        System.out.println("Done");
    }
}
