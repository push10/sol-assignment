package com.sol.tick.solassignment.controller;

import com.sol.tick.solassignment.entities.Statistics;
import com.sol.tick.solassignment.entities.TickStorage;
import com.sol.tick.solassignment.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mapping for Statistics requests
 */
@RestController
public class StatisticsController {
    private static final Logger LOG = LoggerFactory.getLogger(StatisticsController.class);

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(path = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Statistics> fetchStatistics(){
        LOG.info("Fetching aggregation for instruments.");
        statisticsService.aggregateStatistic(6000,null);
        return new ResponseEntity<Statistics>(new Statistics(),HttpStatus.OK);
    }
}
