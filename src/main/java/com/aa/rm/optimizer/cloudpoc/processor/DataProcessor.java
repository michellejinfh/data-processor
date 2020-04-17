package com.aa.rm.optimizer.cloudpoc.processor;

import com.aa.rm.optimizer.cloudpoc.vo.Flight;
import com.aa.rm.optimizer.common.model.FlightData;
import com.aa.rm.optimizer.common.model.ProcessStatus;
import org.openspaces.events.adapter.SpaceDataEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProcessor {
    private final static Logger log = Logger.getLogger(DataProcessor.class.getName());

    public DataProcessor() {
    }

    @SpaceDataEvent
    public FlightData processFlightData(FlightData flightData)
    {
        log.info("Start processFlightData for " + flightData.getFltId() + "," + flightData.getFltDptrDateStr());

        Flight flight = null;

        try
        {
            // sleep to simulate some work
            //
            Thread.sleep(100);

            // Mark this flight as PROCESSED in gigaspace cache
            //
            flightData.setStatus(ProcessStatus.PROCESSED);

            log.info("End processFlightData for " + flightData.getFltId() + "," + flightData.getFltDptrDateStr());
        }
        catch(Exception e)
        {
            // Mark this flight as FAILED in gigaspace cache
            //
            flightData.setStatus(ProcessStatus.FAILED);
            log.log(Level.SEVERE, "processFlightData failed for " + flightData.getFltId() + "," + flightData.getFltDptrDateStr(), e);
            e.printStackTrace();
        }

        return flightData;
    }
}
