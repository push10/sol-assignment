package com.sol.tick.solassignment.service;

/**
 * Service declaration for statistics operations.
 */
public interface StatisticsService {
    void aggregateStatistic(int slidingTime, String inst);
}
