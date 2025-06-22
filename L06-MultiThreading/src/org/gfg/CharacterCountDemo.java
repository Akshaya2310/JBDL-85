package org.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CharacterCountDemo {


    public static void main(String[] args) {

        String str = "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfdd" +
                "sdfghjklmbvcdssfddggfs" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggf" +
                "dfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfggfgfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "";

        int len = str.length();
        int size=10;
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<TaskToCountChar> taskList = new ArrayList<>();
        for(int i=0;i<len; ){
            TaskToCountChar taskToCountChar = new TaskToCountChar(str,i,i+size);
            executorService.submit(taskToCountChar);
            taskList.add(taskToCountChar);
            i=i+size;
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map<Character,Long> result = new HashMap<>();
        for(TaskToCountChar task: taskList){
            Map<Character,Long> taskData = task.getFreqMap();
            for(Character ch: taskData.keySet()){
                if(result.get(ch)==null){
                    result.put(ch,taskData.get(ch));
                }
                else{
                    long newFreq = result.get(ch)+taskData.get(ch);
                    result.put(ch, newFreq);
                }
                //result.put(ch,result.getOrDefault(ch,0l)+taskData.get(ch));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Result:"+result);
        System.out.println("Total Time Taken:"+(end-start)+" ms");
        System.out.println("Done");
    }



}


class TaskToCountChar implements Runnable{

    private String subString;
    int start;
    int end;
    private Map<Character,Long> freqMap = new HashMap<>();

    public TaskToCountChar(String subString, int start, int end) {
        this.subString = subString;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i=start; i<end;i++){
            freqMap.put(subString.charAt(i),freqMap.getOrDefault(subString.charAt(i),0l)+1);
        }
    }

    public Map<Character, Long> getFreqMap() {
        return freqMap;
    }
}
