package tsp;

import utility.Timer;

import java.util.Arrays;
import java.util.Random;

/***************************
 * Project: tsp
 * Date: 03/05/2019
 * Author: Nicolas Favre
 * Description: Simulated Annealing algorithm
 ***************************/


public class SimulatedAnnealing {

    private Random random;
    private int timeLimitMillis;
    private int bestKnown;
    private int[][] distances;
    private Integer[] pathTO;
    private Integer[] path;

    public SimulatedAnnealing(Random random, int timeLimitMillis, int bestKnown, Integer[] pathTO, int[][] distances) {
        this.random = random;
        this.timeLimitMillis = timeLimitMillis;
        this.bestKnown = bestKnown;
        this.pathTO = pathTO;
        this.distances = distances;
    }

    public void solve() {
        double temp = 100, alpha = 0.95;
        Integer[] current = pathTO;
        path = current;

        while (System.currentTimeMillis()-Timer.getStartTime() < timeLimitMillis && bestKnown != getDistance(distances, path)) {
            for (int i = 0; i < 100; i++) {
                TwoOpt to = new TwoOpt(distances, positionSwap(positionSwap(current, 0, ((int)((double)current.length*0.5))), ((int)((double)current.length*0.5)), ((int)((double)current.length*1))));
                Integer[] next = to.getPath();
                int distNext = getDistance(distances, next);
                int distCurrent = getDistance(distances, current);

                if (distNext < distCurrent) {
                    current = next;

                    if (distNext < getDistance(distances, path)) path = next;
                } else {
                    if (randomCheck(distNext, distCurrent, temp)) current = next;
                }
            }

            temp *= alpha;
        }
    }

    private boolean randomCheck(int next, int current, double temp) {
        double r = random.nextDouble();
        double difference = -((double)next - (double)current);
        double d = Math.pow(Math.E, (difference/temp));
        return (r < d);
    }

    private Integer[] positionSwap(Integer[] current, int start, int end) {
        Integer[] tmp = new Integer[current.length];
        int pos[] = new int[4];
        int a = 0, b = 1, c = 2, d = 3;

        for (int i = 0; i < pos.length; i++)
            pos[i] = random.nextInt((end - start - 1)) + start;

        Arrays.sort(pos);

        int count = 0;
        tmp[count] = current[pos[a]];
        count++;

        for (int i = pos[c]+1; i <= pos[d]; i++) {
            tmp[count] = current[i];
            count++;
        }

        for (int i = pos[b]+1; i <= pos[c]; i++) {
            tmp[count] = current[i];
            count++;
        }

        for (int i = pos[a]+1; i <= pos[b]; i++) {
            tmp[count] = current[i];
            count++;
        }

        for (int i = pos[d]+1; i < current.length-1; i++) {
            tmp[count] = current[i];
            count++;
        }

        for (int i = 0; i < pos[a]; i++) {
            tmp[count] = current[i];
            count++;
        }

        tmp[count++] = current[pos[a]];

        return tmp;
    }

    private int getDistance(int[][] matrix, Integer[] path){
        int d = 0;

        for(int i = 0; i < path.length-1; i++) {
            d += matrix[path[i]][path[i+1]];
        }

        return d;
    }

    public Integer[] getPath() {
        return path;
    }
}
