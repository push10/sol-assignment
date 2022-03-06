package com.sol.tick.solassignment.service;

import com.sol.tick.solassignment.entities.Tick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle tick requests.
 */
@RestController
public class TickController {
    private static final Logger logger = LoggerFactory.getLogger(TickController.class);

    @ResponseBody
    @PostMapping(path = "ticks",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity tick(@RequestBody Tick tick) {
        logger.info("Request received for : {}", tick.getInstrument());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
