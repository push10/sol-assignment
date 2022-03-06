package com.sol.tick.solassignment;

import com.sol.tick.solassignment.entities.TickStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolactiveAssignmentApplication {
	private static final Logger logger = LoggerFactory.getLogger(SolactiveAssignmentApplication.class);


	public static void main(String[] args) {
		logger.info("Tick service application starting...");
		logger.info("Initializing Tick Storage...");
		TickStorage.getStorageInstance().initStorage();
		SpringApplication.run(SolactiveAssignmentApplication.class, args);
		logger.info("Tick service application started...");
	}

}
