package com.sol.tick.solassignment.controller;

import com.sol.tick.solassignment.entities.Tick;
import com.sol.tick.solassignment.entities.TickStorage;
import com.sol.tick.solassignment.service.TickService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle tick requests.
 */
@RestController
public class TickController {
    private static final Logger LOG = LoggerFactory.getLogger(TickController.class);
    @Autowired
    private TickService tickService;
    @ResponseBody
    @PostMapping(path = "ticks",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity tick(@RequestBody Tick tick) {
        LOG.info("Request received for : {}", tick.getInstrument());
        tickService.createTick(tick);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
