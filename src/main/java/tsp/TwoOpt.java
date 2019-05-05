package tsp;

/***************************
 * Project: tsp
 * Date: 03/05/2019
 * Author: Nicolas Favre
 * Description: 2-OPT local optimization algorithm
 ***************************/


public class TwoOpt {

    private int[][] distances;
    private Integer[] path;

    public TwoOpt(int[][] distances, Integer[] pathNN) {
        this.distances = distances;
        path = pathNN.clone();
    }

    public void solve() {
        int change, minChange;
        int min_i = 0;
        int min_j = 0;

        do {
            minChange = Integer.MAX_VALUE;

            for (int i = 0; i < path.length-1; i++) {
                for (int j = i+1; j < path.length-1; j++) {
                    change = getChange(i, j);

                    if (minChange > change) {
                        minChange = change;
                        min_i = i;
                        min_j = j;
                        path = swapNodes(min_i, min_j);
                    }
                }
            }
        } while (minChange < 0);
    }

    private int getChange(int i, int j) {
        return distances[path[i]][path[j]] + distances[path[i+1]][path[j+1]] - distances[path[i]][path[i+1]] - distances[path[j]][path[j+1]];
    }

    private Integer[] swapNodes(int i, int j) {
        Integer[] tmp = new Integer[path.length];

        for (int k = 0; k <= i; k++)
            tmp[k] = path[k];

        int count = 0;
        for (int k = i+1; k <= j; k++) {
            tmp[k] = path[j - count];
            count++;
        }

        for (int k = j+1; k < path.length-1; k++)
            tmp[k] = path[k];

        tmp[tmp.length-1] = tmp[0];

        return tmp;
    }

    public Integer[] getPath() {
        return path;
    }
}
