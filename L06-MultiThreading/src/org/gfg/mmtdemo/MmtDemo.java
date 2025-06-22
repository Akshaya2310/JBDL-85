package org.gfg.mmtdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MmtDemo {

    public static void main(String[] args) {

        List<FlightSearchInterface> flightSearchServices = new ArrayList<>();
        flightSearchServices.add(new IndigoFlightSearchService());
        flightSearchServices.add(new AirIndiaFlightSearchService());

        MMTSearchService mmtSearchService = new MMTSearchService(flightSearchServices);

        List<FlightData> allData = mmtSearchService.getAllFlightData("A","B", new Date());
        System.out.println(allData);
    }
}
