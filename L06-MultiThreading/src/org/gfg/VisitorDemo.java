package org.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VisitorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        VisitorCounterTask counterTask = new VisitorCounterTask();
        for(int i=0; i<1000; i++){
            executorService.submit(counterTask);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Visitors:"+counterTask.getCount());

        System.out.println("Done!");


    }
}
