package org.gfg.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        //Queue<Integer> queue =new LinkedList<>(); // FIFO
        Queue<Integer> queue = new PriorityQueue<>(); // minHeap

        queue.add(12);
        queue.add(11);
        queue.add(13);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());




        //Queue<String> stringQueue = new PriorityQueue<>(); // minHeap
        Queue<String> stringQueue = new PriorityQueue<>(Comparator.reverseOrder()); // maxHeap
        stringQueue.add("pqr");
        stringQueue.add("abc");
        stringQueue.add("xyz");
        stringQueue.add("XYZ");
        System.out.println(stringQueue.poll());
        System.out.println(stringQueue.poll());
    }
}
