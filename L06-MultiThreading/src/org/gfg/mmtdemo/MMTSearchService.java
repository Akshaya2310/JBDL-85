package org.gfg.mmtdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MMTSearchService {

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private List<FlightSearchInterface> flightSearchServices;

    public MMTSearchService(List<FlightSearchInterface> flightSearchServices) {
        this.flightSearchServices = flightSearchServices;
    }

    public List<FlightData> getAllFlightData(String src, String dest, Date date){
        List<Callable<List<FlightData>>> callableList = new ArrayList<>();
        for(FlightSearchInterface flightSearchService: flightSearchServices){
            Callable<List<FlightData>> flightCallable = () -> flightSearchService.getFlightData(src,dest,date);
            callableList.add(flightCallable);
        }

        List<FlightData> finalResult = new ArrayList<>();
        try {
            List<Future<List<FlightData>>> futureList =executorService.invokeAll(callableList);
            for(Future<List<FlightData>> future: futureList){
                finalResult.addAll(future.get());
            }
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        return finalResult;
    }

}

