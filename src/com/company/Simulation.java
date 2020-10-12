package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Simulation {
    private final RandomGenerator generator;
    private final double lambda;
    private final double mu;
    private final int entityCount;

    public static void runTest() {
        Simulation simulation = new Simulation(5, 6, 10);
        simulation.runSimulation();
    }

    public Simulation(double lambda, double mu, int entityCount) {
        generator = new RandomGenerator();
        this.lambda = lambda;
        this.mu = mu;
        this.entityCount = entityCount;
    }

    public void runSimulation() {
        double arrivalTime = 0;
        double timeBetweenArrivals = 0;
        double startingService = 0;
        double serviceTime = 0;
        double finishingTime = 0;
        int d = 3;
        System.out.println("entity,arrivalTime, timeBetweenArrivals,startingService,serviceTime,finishingTime");
        for (int i = 1; i <= entityCount; i++) {
            if (i == 1) {
                timeBetweenArrivals = generator.getExponentialRandomNext(this.lambda);
                serviceTime = generator.getExponentialRandomNext(this.mu);
                finishingTime = startingService + serviceTime;
            } else {
                arrivalTime = arrivalTime + timeBetweenArrivals;
                timeBetweenArrivals = generator.getExponentialRandomNext(this.lambda);
                startingService = Math.max(arrivalTime, finishingTime);
                serviceTime = generator.getExponentialRandomNext(this.mu);
                finishingTime = startingService + serviceTime;
            }
            System.out.println(i + ", " + round(arrivalTime, d) + ", " + round(timeBetweenArrivals, d) + ", " + round(startingService, d) + ", " + round(serviceTime, d) + ", " + round(finishingTime, d));
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
