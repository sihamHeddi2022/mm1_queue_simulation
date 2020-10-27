package com.company;

import java.util.Random;

/* This class is responsible for all random number generation */

public class RandomGenerator implements Generator {
    private static final Random rand = new Random();

    public RandomGenerator() {
    }

    @Override
    public double getUniformRandomNext() {
        return rand.nextDouble();
    }

    @Override
    public double getNegativeExponentialRandomNext(double value) {
        return Math.log(1 - getUniformRandomNext()) / (-value);
    }

}
