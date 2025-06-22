package org.gfg.waitnotify;

public class SharedData {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until data is consumed
        }
        this.data = value;
        System.out.println("Produced: " + value);
        hasData = true;
        notify(); // notify consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until data is produced
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // notify producer
        return data;
    }




}
