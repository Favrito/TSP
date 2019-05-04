package tsp;

import model.Node;
import model.ParsedFile;
import utility.Parser;

import java.util.List;
import java.util.Random;

/***************************
 * Project: tsp
 * Date: 27/02/2019
 * Author: Nicolas Favre
 * Description: Main class for solving TSP
 ***************************/


public class TSP {

    private int[][] distances;
    private Integer[] pathNN;
    private Integer[] pathTO;
    private Integer[] pathSA;
    private int bestKnown;
    private int timeLimitMillis;
    private List<Node> allNodes;
    private Random random;

    public TSP(String fileName) {
        Parser parser = new Parser();
        ParsedFile parsedFile = parser.readFile(fileName);
        this.distances = parsedFile.getMatrix();
        this.bestKnown = parsedFile.getBestKnown();
        timeLimitMillis = 1000;
        this.allNodes = parsedFile.getAllNodes();
        // long seed = System.currentTimeMillis();
        random = new Random(1556969034975L);
    }

    public Integer[] solveNN() {
        NearestNeighbour nn = new NearestNeighbour(distances);
        nn.solve();
        pathNN = nn.getPath();
        return pathNN;
    }

    public Integer[] solveTO() {
        TwoOpt to = new TwoOpt(distances, pathNN);
        to.solve();
        pathTO = to.getPath();
        return pathTO;
    }

    public Integer[] solveSA() {
        SimulatedAnnealing sa = new SimulatedAnnealing(random, timeLimitMillis, bestKnown, pathTO, distances);
        sa.solve();
        pathSA = sa.getPath();
        return pathSA;
    }

    public int getBestKnown() {
        return bestKnown;
    }

    public List<Node> getAllNodes() {
        return allNodes;
    }

    public int computeTotalDistance(Integer[] path) {
        int distance = 0;

        for (int i = 0; i < path.length-1; i++) {
            distance += distances[path[i]][path[i+1]];
        }

        return distance;
    }

}
