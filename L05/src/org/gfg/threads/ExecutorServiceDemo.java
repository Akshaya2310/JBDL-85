package org.gfg.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            Integer a=i;
            executorService.submit(() ->{
                System.out.println("i="+a+"Task Running in : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Done!");
        System.out.println("Total Time:"+(end-start)+" ms Thread:"+Thread.currentThread().getName());

    }
}
