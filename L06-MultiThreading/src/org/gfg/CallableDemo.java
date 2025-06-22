package org.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.ForkJoinTask.invokeAll;


public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task = new Task();
        Future<Signal> future = executorService.submit(()-> {
            System.out.println("Executing in:"+Thread.currentThread().getName());
            return new Signal();
        });
        Future<String> stringFuture = executorService.submit(task);
        try {
            String data = stringFuture.get();
            System.out.println(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");


        List<Task> list = new ArrayList<>();
        list.add(task);
        list.add(new Task());
        list.add(new Task());
        list.add(new Task());

        try {
            List<Future<String>> futureList = executorService.invokeAll(list);
            for(Future<String> futureStr : futureList){
                try {
                    System.out.println(futureStr.get(10,TimeUnit.SECONDS));
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}


class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        /*

         */
        return "Result:"+Math.random();
    }
}