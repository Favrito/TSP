package model;

import java.util.List;

/***************************
 * Project: tsp
 * Date: 07/03/2019
 * Author: Nicolas Favre
 * Description: Class for file parsing results
 ***************************/


public class ParsedFile {

    private final int[][] matrix;
    private final int bestKnown;
    private final List<Node> allNodes;

    // Class containing information about nodes in file
    public ParsedFile(int[][] matrix, int bestKnown, List<Node> allNodes) {
        this.matrix = matrix;
        this.bestKnown = bestKnown;
        this.allNodes = allNodes;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getBestKnown() {
        return bestKnown;
    }

    public List<Node> getAllNodes() {
        return allNodes;
    }

}
