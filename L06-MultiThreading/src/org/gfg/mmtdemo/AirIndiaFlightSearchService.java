package org.gfg.mmtdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirIndiaFlightSearchService implements FlightSearchInterface{
    @Override
    public List<FlightData> getFlightData(String src, String dest, Date date) {
        /*
        AirIndia APIs
         */
        List<FlightData> flightData = new ArrayList<>();
        flightData.add(new FlightData("A","B",10000.00));
        flightData.add(new FlightData("A","B",9000.00));
        flightData.add(new FlightData("A","B",11000.00));
        return flightData;
    }
}
