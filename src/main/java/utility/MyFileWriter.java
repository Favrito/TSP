package utility;

import model.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/***************************
 * Project: tsp
 * Date: 08/03/2019
 * Author: Nicolas Favre
 * Description: Test for creating solution files
 ***************************/


public class MyFileWriter {

    public static void writePlotFile(Integer[] tour, List<Node> allNodes) {
        try {
            FileWriter fileWriter = new FileWriter(new File("solution/nodes"));
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write all nodes to be plotted
            for (int node : tour)
                printWriter.println(allNodes.get(node).getId() + "\t" + allNodes.get(node).getX() + "\t" + allNodes.get(node).getY());

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeSolutionFile(String fileName, int distance, Integer[] tour, List<Node> allNodes) {
        String filePath = "solution/" + fileName + ".opt.tour";

        try {
            FileWriter fileWriter = new FileWriter(new File(filePath));
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write file header
            printWriter.println("NAME : " + fileName + ".opt.tour");
            printWriter.println("COMMENT : Optimum tour for " + fileName + ".tsp (" + distance + ")");
            printWriter.println("TYPE : TOUR");
            printWriter.println("DIMENSION : " + (tour.length-1));
            printWriter.println("TOUR_SECTION");

            // Write solution path
            for (int i = 0; i < tour.length-1; i++)
                printWriter.println(allNodes.get(tour[i]).getId());

            printWriter.println("-1");
            printWriter.println("EOF");

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
