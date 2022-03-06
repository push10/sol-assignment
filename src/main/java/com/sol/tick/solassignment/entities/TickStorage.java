package com.sol.tick.solassignment.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Utility class for storing the instrument over the blocking queue.
 */
public class TickStorage {
    private static final Logger LOG = LoggerFactory.getLogger(TickStorage.class);
    private static TickStorage storageInstance;
    private LinkedBlockingQueue<Tick> tickStorageQ;

    public void initStorage(){
        if(tickStorageQ == null){
            LOG.info("Tick internal storage is initializing.");
            tickStorageQ = new LinkedBlockingQueue<>();
        }
    }
    public static TickStorage getStorageInstance()
    {
        if (storageInstance == null)
        {
            storageInstance = new TickStorage();
        }
        return storageInstance;
    }

    public LinkedBlockingQueue<Tick> getTickStorageQ() {
        return tickStorageQ;
    }

    public void registerTick(Tick tick)
    {
        try
        {
            tickStorageQ.put(tick);
        }
        catch (InterruptedException e)
        {
            LOG.error("Failed to put tickQueue {0} to instrumentQueue", tick.getInstrument());
        }
    }
}
