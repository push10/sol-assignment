package com.sol.tick.solassignment.service;

import com.sol.tick.solassignment.entities.Tick;
import com.sol.tick.solassignment.entities.TickStorage;
import org.springframework.stereotype.Service;

/**
 * Tick service for instrument registration.
 */
@Service
public class TickServiceImpl implements TickService{
    @Override
    public void createTick(Tick tick) {
        new Thread(() -> TickStorage.getStorageInstance().registerTick(tick)).start();
    }
}
