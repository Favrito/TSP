import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***************************
 * Project: tsp
 * Date: 19/02/2019
 * Author: Nicolas Favre
 * Description: 
 ***************************/


class FileManager {

    private static int dimension = 0;
    private static int[][] distances = null;
    private static List<Node> allNodes = new ArrayList<>();

    static int[][] readFile(String fileName) throws FileNotFoundException, NullPointerException {
        Scanner scanner = new Scanner(new File(FileManager.class.getResource(fileName).getFile()));

        // Consume file header and initialize distance matrix
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");

            if (words[0].equals("DIMENSION")) {
                dimension = Integer.parseInt(words[2]);
                distances = new int[dimension][dimension];
            }

            if (words[0].equals("NODE_COORD_SECTION")) break;
        }

        // Populate distance matrix
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] triad = line.split(" ");

            if (line.equals("EOF")) {
                break;
            }
            else {
                Node city = new Node(Integer.parseInt(triad[0]), Double.parseDouble(triad[1]), Double.parseDouble(triad[2]));
                allNodes.add(city);
            }
        }

        createDistanceMatrix();

        scanner.close();
        return distances;
    }

    // Upper triangular matrix
    private static void createDistanceMatrix() {
        for (int i = 0; i < dimension; i++) {
            for (int j = i + 1; j < dimension; j++) {
                distances[i][j] = distance(allNodes.get(i), allNodes.get(j));
            }
        }
    }

    // Calculate euclidean distance between two cities
    private static int distance(Node city1, Node city2) {
        return (int)(Math.sqrt(Math.pow(city2.getX() - city1.getX(), 2) + Math.pow(city2.getY() - city1.getY(), 2)) + 0.5);
    }

}
