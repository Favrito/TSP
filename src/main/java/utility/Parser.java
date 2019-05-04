package utility;

import model.Node;
import model.ParsedFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***************************
 * Project: tsp
 * Date: 19/02/2019
 * Author: Nicolas Favre
 * Description: File parser and distances matrix creation
 ***************************/


public class Parser {

    // Read file and return instance of model.ParsedFile
    public ParsedFile readFile(String fileName) {
        Scanner scanner;
        List<Node> allNodes = null;
        int[][] matrix = null;
        int dimension = 0;
        int bestKnown = 0;

        try {
            scanner = new Scanner(new File(Parser.class.getResource("../problems/" + fileName).getFile()));

            // Consume file header
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");

                if (words[0].equals("DIMENSION"))
                    dimension = Integer.parseInt(words[2]);

                if (words[0].equals("BEST_KNOWN"))
                    bestKnown = Integer.parseInt(words[2]);

                if (words[0].equals("NODE_COORD_SECTION"))
                    break;
            }

            allNodes = new ArrayList<>();

            // Populate list with all nodes
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] triad = line.split(" ");

                if (line.equals("EOF")) {
                    break;
                }
                else {
                    Node node = new Node(Integer.parseInt(triad[0]), Double.parseDouble(triad[1]), Double.parseDouble(triad[2]));
                    allNodes.add(node);
                }
            }

            matrix = computeDistanceMatrix(allNodes, dimension);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.format("Exception occurred trying to read '%s'.\n", fileName);
            System.exit(1);
        } catch (NullPointerException e) {
            System.err.format("File '%s' not found.\n", fileName);
            System.exit(1);
        }

        return new ParsedFile(matrix, bestKnown, allNodes);
    }

    // Compute distance matrix
    private int[][] computeDistanceMatrix(List<Node> allNodes, int dimension) {
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                matrix[i][j] = distance(allNodes.get(i), allNodes.get(j));
                matrix[j][i] = matrix[i][j];
            }
        }
        return matrix;
    }

    // Calculate euclidean distance between two nodes
    private int distance(Node city1, Node city2) {
        return (int)(Math.sqrt(Math.pow(city2.getX() - city1.getX(), 2) + Math.pow(city2.getY() - city1.getY(), 2)) + 0.5);
    }

}
