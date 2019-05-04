import tsp.TSP;
import utility.GnuPlotUtils;
import utility.MyFileWriter;
import utility.Timer;

/***************************
 * Project: tsp
 * Date: 18/02/2019
 * Author: Nicolas Favre
 * Description: Program entry point
 ***************************/


public class Main {

    public static void main(String[] args) {
        Timer.start();

        String fileName = null;
        TSP tsp = null;
        Integer[] pathNN;
        Integer[] pathTO;
        Integer[] pathSA;

        if (args.length == 1) {
            fileName = args[0];
            int length = fileName.length();

            // Parse file if format is .tsp
            if (fileName.substring(length-4, length).equals(".tsp")) {
                // Start algorithm
                tsp = new TSP(fileName);
            }
            else {
                System.err.format("Unexpected file format, must be '.tsp'.\n");
            }
        }
        else {
            System.err.format("Filename must be passed as argument.\n");
        }

        int bestKnown = tsp.getBestKnown();
        System.out.format("File: %s", fileName);
        System.out.format("\nBest known tour distance: %s\n\n", bestKnown);

        // Nearest Neighbour
        pathNN = tsp.solveNN();
        int distanceNN = tsp.computeTotalDistance(pathNN);
        System.out.format("NN tour distance: %s\n", distanceNN);
        float errorNN = 100.0f*(distanceNN-bestKnown)/bestKnown;
        System.out.println("NN error: " + errorNN + "%\n");

        // 2-OPT
        pathTO = tsp.solveTO();
        int distanceTO = tsp.computeTotalDistance(pathTO);
        System.out.format("TO tour distance: %s\n", distanceTO);
        float errorTO = 100.0f*(distanceTO-bestKnown)/bestKnown;
        System.out.println("TO error: " + errorTO + "%\n");

        // Simulated Annealing
        pathSA = tsp.solveSA();
        int distanceSA = tsp.computeTotalDistance(pathSA);
        System.out.format("SA tour distance: %s\n", distanceSA);
        float errorSA = 100.0f*(distanceSA-bestKnown)/bestKnown;
        System.out.println("SA error: " + errorSA + "%");

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile(fileName.substring(0, fileName.length()-4), distanceSA, pathSA, tsp.getAllNodes());
        MyFileWriter.writePlotFile(pathSA, tsp.getAllNodes());

        // Plot tour
        GnuPlotUtils.plotTour();

        // Log execution time
        Timer.end();
        System.out.format("\nExecution time: %s ms\n", Timer.getElapsedTime());
    }

}
