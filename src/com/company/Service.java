package com.company;

@SuppressWarnings("ALL")
public class Service {

    /* instance of a processed member in a queue */

    private double arrivalTime = 0;
    private double timeBetweenArrivals = 0;
    private double startingService = 0;
    private double serviceTime;
    private double finishingTime = 0;

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getTimeBetweenArrivals() {
        return timeBetweenArrivals;
    }

    public void setTimeBetweenArrivals(double timeBetweenArrivals) {
        this.timeBetweenArrivals = timeBetweenArrivals;
    }

    public double getStartingService() {
        return startingService;
    }

    public void setStartingService(double startingService) {
        this.startingService = startingService;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(double finishingTime) {
        this.finishingTime = finishingTime;
    }

    @Override
    public String toString(){
        return arrivalTime + ", " + timeBetweenArrivals + ", " + startingService + ", " + serviceTime + ", " + finishingTime;
    }
}
