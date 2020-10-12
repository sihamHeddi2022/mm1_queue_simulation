package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Simulation {

    /* MM1Q Implementation for N entities */

    private final RandomGenerator generator;
    private final double lambda;
    private final double mu;
    private final int entityCount;

    public Simulation(double lambda, double mu, int entityCount) {
        this.generator = new RandomGenerator();
        this.lambda = lambda;
        this.mu = mu;
        this.entityCount = entityCount;
    }

    public Result run(){
        return runSimulation(3);
    }

    public Result runSimulation(int decimalPlaces) {
        double arrivalTime = 0;
        double timeBetweenArrivals = 0;
        double startingService = 0;
        double serviceTime;
        double finishingTime = 0;
        Result result = new Result();

        for (int i = 1; i <= entityCount; i++) {
            Service service = new Service();
            if (i == 1) {
                timeBetweenArrivals = generator.getExponentialRandomNext(this.lambda);
            } else {
                arrivalTime = arrivalTime + timeBetweenArrivals;
                timeBetweenArrivals = generator.getExponentialRandomNext(this.lambda);
                startingService = Math.max(arrivalTime, finishingTime);
            }
            serviceTime = generator.getExponentialRandomNext(this.mu);
            finishingTime = startingService + serviceTime;

            service.setArrivalTime(round(arrivalTime, decimalPlaces));
            service.setTimeBetweenArrivals(round(timeBetweenArrivals, decimalPlaces));
            service.setStartingService(round(startingService, decimalPlaces));
            service.setServiceTime(round(serviceTime, decimalPlaces));
            service.setFinishingTime(round(finishingTime, decimalPlaces));

            result.addService(service);
        }
        return result;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
