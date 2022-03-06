package com.sol.tick.solassignment.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Utility class for storing the instrument over the blocking queue.
 */
public class TickStorage {
    private static final Logger LOG = LoggerFactory.getLogger(TickStorage.class);
    private static TickStorage storageInstance;
    private LinkedBlockingQueue<Tick> tickStorageQ;
    // q for holding the list of tick for instrument
    private Map<String, LinkedBlockingQueue<Tick>> tickStoragePerInstMap;
    private LinkedBlockingQueue<Tick> tickList;

    public void initStorage() {
        LOG.info("Tick internal storage is initializing.");
        if (tickStorageQ == null) {
            tickStorageQ = new LinkedBlockingQueue<>();
        }

        if (tickStoragePerInstMap == null) {
            tickStoragePerInstMap = new ConcurrentHashMap<>();
        }
        if (tickList == null) {
            tickList = new LinkedBlockingQueue<Tick>();
        }
    }

    public static TickStorage getStorageInstance() {
        if (storageInstance == null) {
            storageInstance = new TickStorage();
        }
        return storageInstance;
    }

    public LinkedBlockingQueue<Tick> getTickStorageQ() {
        return tickStorageQ;
    }

    public Map<String, LinkedBlockingQueue<Tick>> getTickStoragePerInstMap() {
        return tickStoragePerInstMap;
    }

    public void registerTick(Tick tick) {
        try {
            tickStorageQ.put(tick);
        } catch (InterruptedException e) {
            LOG.error("Failed to put tickQueue {0} to instrumentQueue", tick.getInstrument());
        }
    }
}
