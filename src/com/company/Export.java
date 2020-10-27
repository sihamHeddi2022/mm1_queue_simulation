package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Export {

    /* for creating reports from a Result object */

    private static final String HEADER = "arrivalTime, timeBetweenArrivals, startingService, serviceTime , finishingTime";


    public static void output(Result result, String fileName) {
        Export.output(result, fileName, true, true);
    }

    public static void output(Result result, String fileName, boolean indexRequired, boolean headersRequired) {
        File csvOutputFile = new File(fileName);
        long index = 0;
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            for (Service service : result.getResults()) {
                if (headersRequired && index == 0) {
                    String header = (indexRequired ? "_id," : "") + HEADER + "\n";
                    pw.write(header);
                }
                String line = (indexRequired ? index + "," : "") + service.toString() + "\n";
                pw.write(line);
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void output(Result result) {
        // output to console if no filename specified
        long index = 0;
        String header = "_id," + HEADER + "\n";
        System.out.println(header);
        for (Service service : result.getResults()) {
            String line = index + ","  + service.toString();
            System.out.println(line);
            index++;
        }
    }

}
