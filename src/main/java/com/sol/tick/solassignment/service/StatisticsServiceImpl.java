package com.sol.tick.solassignment.service;

import com.sol.tick.solassignment.entities.TickStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for statistics aggregation
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{
    private static final Logger LOG = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Override
    public void aggregateStatistic(int slidingTime, String inst) {
        if(Optional.ofNullable(inst).isPresent()){
            LOG.info("Aggregation starts for {}",inst);
            // do inst specific aggregation
        }else {
            LOG.info("Aggregation starts for all instruments.");
            // aggregate all inst falls withing given time interval
        }
    }
}
