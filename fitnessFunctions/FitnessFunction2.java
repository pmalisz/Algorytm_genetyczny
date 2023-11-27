import java.util.*;

public class FitnessFunction2 implements gp.project.GPManager.FitnessFunction {
    public double fitnessFunction(List<List<Integer>> outputs, int[][] targets, int varNumber) {
        double fit = 0.0;
        boolean theSame = true;
        for (int i = 0; i < outputs.size(); i++) {
            List<Integer> listToCompare = new ArrayList<>();

            if (i>0)
                if (!listToCompare.equals(outputs.get(i)))
                    theSame = false;

            double tempFit = Double.MAX_VALUE;
            for (int j = 0; j < outputs.get(i).size(); j++) {
                if (i==0) listToCompare.add(outputs.get(i).get(j));

                double diff = Math.abs(outputs.get(i).get(j) - targets[i][varNumber]);
                if (diff < tempFit)
                    tempFit = diff;
            }

            fit = tempFit > 1e30 ? tempFit : fit + tempFit;
        }

        if(theSame) return Double.MAX_VALUE;

        return -fit;
    }
}