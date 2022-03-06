package com.sol.tick.solassignment.service;

import com.sol.tick.solassignment.entities.Tick;

public interface TickService {
    /**
     * Method for registering instrument.
     * @param tick
     */
    void createTick(Tick tick);
}
