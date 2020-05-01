package com.aa.rm.optimizer.cloudpoc.processor;

import com.aa.rm.optimizer.cloudpoc.vo.Flight;
import com.aa.rm.optimizer.common.model.BPCData;
import com.aa.rm.optimizer.common.model.FlightData;
import com.aa.rm.optimizer.common.model.ProcessStatus;
import org.openspaces.core.GigaSpace;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProcessor {
    @Autowired
    private GigaSpace gigaSpace;

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
//            Thread.sleep(100);

            BPCData bpcData = new BPCData();
            initBPCDataSpaceObject(bpcData, flightData);
            gigaSpace.write(bpcData);

            log.info("Finish writing BPCData space object for " + flightData.getFltId() + "," + flightData.getFltDptrDateStr());

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

    protected void initBPCDataSpaceObject(BPCData bpc, FlightData flight)
    {
        bpc.setFlightKey(new StringBuffer().append(flight.getFltDptrDateStr()).append(flight.getFltId()).toString());
        bpc.setFlightId(Integer.parseInt(flight.getFltId()));
        bpc.setDepartureDate(flight.getFltDptrDateAsDate());
        bpc.setOrigin(flight.getOrigin());
        bpc.setDest(flight.getDest());
        bpc.setFlightNumber(flight.getFltNumber());
        bpc.setFltDptrTime(flight.getFltDptrTime());
        bpc.setFcstId(flight.getFcstId());
        bpc.setFcstDow(flight.getFcstDow());
        bpc.setFcstDptrDate(flight.getFcstDptrDate());
        bpc.setStatus(ProcessStatus.READY);

        // Set routing ID as (origin, destination, fcstId)
        //
        bpc.setSpaceRoutingId(bpc.calculateRoutingId());
    }
}
