package com.company;

import java.util.Random;

/*
This class is responsible for all random number generation
 */

public class RandomGenerator {
    private static final Random rand = new Random();

    public RandomGenerator() {
    }

    public double getUniformRandomNext(){
        return rand.nextDouble();
    }

    public double getExponentialRandomNext(double value) {
        return Math.log(1 - getUniformRandomNext()) / (-value);
    }

}
