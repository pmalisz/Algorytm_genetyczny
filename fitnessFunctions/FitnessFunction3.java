import java.util.*;

public class FitnessFunction3 implements gp.project.GPManager.FitnessFunction {
    public double fitnessFunction(List<List<Integer>> outputs, int[][] targets, int varNumber) {
        double fit = 0.0;

        for (int i = 0; i < outputs.size(); i++) {
            double tempFit = Double.MAX_VALUE;

            if (outputs.get(i).size() != 1)
                return -tempFit;

            if (i>0)
                if (Objects.equals(outputs.get(0).get(0), outputs.get(i).get(0)))
                    return -tempFit;

            tempFit = Math.abs(outputs.get(i).get(0) - targets[i][varNumber]);
            fit += tempFit;
        }

        return -fit;
    }
}