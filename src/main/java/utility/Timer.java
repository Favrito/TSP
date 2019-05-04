package utility;

/***************************
 * Project: tsp
 * Date: 19/02/2019
 * Author: Nicolas Favre
 * Description: Class for logging execution time
 ***************************/


public class Timer {

    private static long startTime = 0;
    private static long endTime = 0;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        endTime = System.currentTimeMillis();
    }

    public static long getElapsedTime() {
        return endTime - startTime;
    }

    public static long getStartTime() {
        return startTime;
    }

}
