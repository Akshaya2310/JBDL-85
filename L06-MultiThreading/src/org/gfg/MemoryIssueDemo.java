package org.gfg;

public class MemoryIssueDemo {

    public static void main(String[] args) {

        Signal signal = new Signal();

        Thread thread1 = new Thread(() -> {
            try {
                /*

                 */
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            signal.setStop(true);
            System.out.println("Setting to true in thread " + Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            while (!signal.isStop()) {
                System.out.println("Executing in thread " + Thread.currentThread().getName());
            }
        });

        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.start();

        System.out.println("Done!");
    }
}
