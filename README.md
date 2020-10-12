# MM1Q

Basic MM1Q simulation in Java.

## Implementation

This runs the simulation for lambda=4, mu=5 and entity count = 10000.

Results are exported to a csv file.

        Simulation simulation = new Simulation(4,5,10000);
        Result result = simulation.runSimulation();
        Export.output(result,"results.csv");

## Further Information

https://en.wikipedia.org/wiki/M/M/1_queue
