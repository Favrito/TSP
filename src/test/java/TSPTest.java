import org.junit.Test;
import tsp.TSP;
import utility.MyFileWriter;
import utility.Timer;

/***************************
 * Project: tsp
 * Date: 29/04/2019
 * Author: Nicolas Favre
 * Description: Test class
 ***************************/


public class TSPTest {

    @Test(timeout = 181000)
    public void ch130() {
        Timer.start();
        TSP ch130_test = new TSP("ch130.tsp");

        // Nearest Neighbour
        ch130_test.solveNN();

        // 2-OPT
        ch130_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = ch130_test.solveSA();
        int distanceSA = ch130_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("ch130", distanceSA, pathSA, ch130_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void d198() {
        Timer.start();
        TSP d198_test = new TSP("d198.tsp");

        // Nearest Neighbour
        d198_test.solveNN();

        // 2-OPT
        d198_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = d198_test.solveSA();
        int distanceSA = d198_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("d198", distanceSA, pathSA, d198_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void eil76() {
        Timer.start();
        TSP eil76_test = new TSP("eil76.tsp");

        // Nearest Neighbour
        eil76_test.solveNN();

        // 2-OPT
        eil76_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = eil76_test.solveSA();
        int distanceSA = eil76_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("eil76", distanceSA, pathSA, eil76_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void fl1577() {
        Timer.start();
        TSP fl1577_test = new TSP("fl1577.tsp");

        // Nearest Neighbour
        fl1577_test.solveNN();

        // 2-OPT
        fl1577_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = fl1577_test.solveSA();
        int distanceSA = fl1577_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("fl1577", distanceSA, pathSA, fl1577_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void kroA100() {
        Timer.start();
        TSP kroA100_test = new TSP("kroA100.tsp");

        // Nearest Neighbour
        kroA100_test.solveNN();

        // 2-OPT
        kroA100_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = kroA100_test.solveSA();
        int distanceSA = kroA100_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("kroA100", distanceSA, pathSA, kroA100_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void lin318() {
        Timer.start();
        TSP lin318_test = new TSP("lin318.tsp");

        // Nearest Neighbour
        lin318_test.solveNN();

        // 2-OPT
        lin318_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = lin318_test.solveSA();
        int distanceSA = lin318_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("lin318", distanceSA, pathSA, lin318_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void pcb442() {
        Timer.start();
        TSP pcb442_test = new TSP("pcb442.tsp");

        // Nearest Neighbour
        pcb442_test.solveNN();

        // 2-OPT
        pcb442_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = pcb442_test.solveSA();
        int distanceSA = pcb442_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("pcb442", distanceSA, pathSA, pcb442_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void pr439() {
        Timer.start();
        TSP pr439_test = new TSP("pr439.tsp");

        // Nearest Neighbour
        pr439_test.solveNN();

        // 2-OPT
        pr439_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = pr439_test.solveSA();
        int distanceSA = pr439_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("pr439", distanceSA, pathSA, pr439_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void rat783() {
        Timer.start();
        TSP rat783_test = new TSP("rat783.tsp");

        // Nearest Neighbour
        rat783_test.solveNN();

        // 2-OPT
        rat783_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = rat783_test.solveSA();
        int distanceSA = rat783_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("rat783", distanceSA, pathSA, rat783_test.getAllNodes());
        Timer.end();
    }

    @Test(timeout = 181000)
    public void u1060() {
        Timer.start();
        TSP u1060_test = new TSP("u1060.tsp");

        // Nearest Neighbour
        u1060_test.solveNN();

        // 2-OPT
        u1060_test.solveTO();

        // Simulated Annealing
        Integer[] pathSA = u1060_test.solveSA();
        int distanceSA = u1060_test.computeTotalDistance(pathSA);

        // Write solution file and file for plot
        MyFileWriter.writeSolutionFile("u1060", distanceSA, pathSA, u1060_test.getAllNodes());
        Timer.end();
    }

}
