package org.gfg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VisitorCounterTask implements Runnable {

    //private AtomicInteger count = new AtomicInteger();

    private Lock lock = new ReentrantLock();

    private int count = 0;

//     public synchronized void increment(){
//        count++;
//    }

//    public void increment(){
//        /*
//        10 line
//         */
//        count.incrementAndGet();
//        /*
//        10 line
//         */
//    }

    public void increment(){
        lock.lock();
        count++;
        lock.unlock();
    }




    public int getCount(){
        return count;
    }

//    public int getCount(){
//        return count.get();
//    }

    @Override
    public void run() {
        increment();
    }
}
