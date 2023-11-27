import java.util.*;

public class FitnessFunction4 implements gp.project.GPManager.FitnessFunction {
    public double fitnessFunction(List<List<Integer>> outputs, int[][] targets, int varNumber) {
        double fit = 0.0;

        for (int i = 0; i < outputs.size(); i++) {
            double tempFit = Double.MAX_VALUE;

            if (outputs.get(i).size() != 1)
                return -tempFit;

            tempFit = Math.abs(outputs.get(i).get(0) - targets[i][varNumber]);
            if (tempFit != 0)
                fit += 0.1;
        }

        return -fit;
    }
}