package com.company;


import java.util.ArrayList;

public class Result {

    /* all data is returned in this object from the simulation */

    private final ArrayList<Service> results = new ArrayList<>();

    public void addService(Service service){
        results.add(service);
    }

    public ArrayList<Service> getResults(){
        return results;
    }

}
