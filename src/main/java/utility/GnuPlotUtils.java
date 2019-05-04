package utility;

import java.io.IOException;

/***************************
 * Project: tsp
 * Date: 08/03/2019
 * Author: Nicolas Favre
 * Description: Class for plot process execution
 ***************************/


public class GnuPlotUtils {

    public static void plotTour() {
        try {
            Process p = Runtime.getRuntime().exec("gnuplot -p \"plot.p\"");
        } catch (IOException e) {
            System.err.println("GnuPlot not installed. Visit: http://www.gnuplot.info");
        }
    }

}
