package tsp;

/***************************
 * Project: tsp
 * Date: 03/05/2019
 * Author: Nicolas Favre
 * Description: Nearest Neighbour algorithm
 ***************************/


public class NearestNeighbour {

    private int[][] distances;
    private Integer[] path;

    public NearestNeighbour(int[][] distances) {
        this.distances = distances;
        path = new Integer[distances.length+1];
    }

    public Integer[] solve() {
        int count = 0;
        Integer start = 0;
        path[count] = start;
        count++;
        Integer next = start;

        for (int i = 0; i < distances.length-1; i++) {
            if(i == 0) {
                next = findMin(path, start);
                path[count] = next;
                count++;
            }
            else {
                next = findMin(path,next);
                path[count] = next;
                count++;
            }
        }

        path[distances.length] = start;

        return path;
    }

    private int findMin(Integer[] path, Integer i) {
        int min = Integer.MAX_VALUE;
        Integer next = i;

        for (int j = 0; j < distances[i].length; j++) {
            if (j == i)
                continue;
            else
                if (min > distances[i][j] && !contains(path, j)) {
                    min = distances[i][j];
                    next = j;
                }
        }

        return next;
    }

    private boolean contains(Integer[] path, int j) {
        boolean flag = false;

        for (Integer p : path) {
            if (p != null)
                if (p == j)
                    flag = true;
        }
        return flag;
    }

    public Integer[] getPath() {
        return path;
    }

}
