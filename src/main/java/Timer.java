/***************************
 * Project: tsp
 * Date: 19/02/2019
 * Author: Nicolas Favre
 * Description: 
 ***************************/


class Timer {

    private static long startTime = 0;
    private static long endTime = 0;

    static void start() {
        startTime = System.currentTimeMillis();
    }

    static void end() {
        endTime = System.currentTimeMillis();
    }

    static long getElapsedTime() {
        return endTime - startTime;
    }

}
