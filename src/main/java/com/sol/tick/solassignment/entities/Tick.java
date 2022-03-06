package com.sol.tick.solassignment.entities;

import lombok.Data;

@Data
public class Tick {
    private String instrument;
    private double price;
    private long timestamp;
}
