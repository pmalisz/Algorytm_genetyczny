import java.util.List;

public class FitnessFunction implements gp.project.GPManager.FitnessFunction {
    public double fitnessFunction(List<List<Integer>> outputs, int[][] targets, int varNumber) {
        double fit = 0.0;
        for (int i = 0; i < outputs.size(); i++) {
            double tempFit = Double.MAX_VALUE;
            for (int j = 0; j < outputs.get(i).size(); j++) {
                double diff = Math.abs(outputs.get(i).get(j) - targets[i][varNumber]);
                if (diff < tempFit)
                    tempFit = diff;
            }

            fit = tempFit > 1e30 ? tempFit : fit + tempFit;
        }

        return -fit;
    }
}