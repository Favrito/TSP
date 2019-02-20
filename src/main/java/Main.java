import java.io.FileNotFoundException;

/***************************
 * Project: tsp
 * Date: 18/02/2019
 * Author: Nicolas Favre
 * Description: 
 ***************************/


public class Main {

    public static void main(String[] args) {
        Timer.start();

        int[][] distances = null;

        if (args.length == 1) {
            String fileName = args[0];
            int length = fileName.length();

            // Read file if format is TSP
            if (fileName.substring(length-4, length).equals(".tsp"))
                try {
                    // Parse file and return distance matrix
                    distances = FileManager.readFile(fileName);
                } catch (FileNotFoundException e) {
                    System.err.format("Exception occurred trying to read '%s'.\n", fileName);
                } catch (NullPointerException e) {
                    System.err.format("File '%s' not found.\n", fileName);
                }
            else
                System.err.format("Unexpected file format, must be '.tsp'.\n");
        }
        else {
            System.err.format("Filename must be passed as argument.\n");
        }

        printMatrix(distances);

        // Log execution time
        Timer.end();
        System.out.format("\nExecution time: %s ms\n", Timer.getElapsedTime());
    }

    private static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j< m.length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
