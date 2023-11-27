package gp.project;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import javax.tools.*;

public class GPManager {
    // CONST
    final int
            POP_SIZE = 2000,
            GENERATIONS = 1000,
            RANDOM_COUNT = 105,
            T_SIZE = 5;
    public final double
            CROSSOVER_PROB = 0.5,
            EPSILON = 0;

    // VAR
    static Random rd = new Random();
    Serialize serializer = new Serialize("results/test.csv", true);
    FitnessFunction fitnessObj;

    List<Tree> population;
    double[] fitness;
    int minRandom, maxRandom;
    int varNumber, fitnessCases, randomNumber;
    long seed;
    int[][] targets;

    public GPManager(String fileName, String fitnessFunctionFileName, long s ) {
        population = new ArrayList<>();
        fitness =  new double[POP_SIZE];

        seed = s;
        if (seed >= 0L) {
            rd.setSeed(seed);
            Tree.setSeed(seed);
        }

        setup(fileName);
        setupFitnessFunction(fitnessFunctionFileName);
        for (int i = 0; i < RANDOM_COUNT; i++ )
            Tree.addRandomNumber(minRandom, maxRandom);

        createRandomPopulation(fitness);
    }

    void setup(String fileName) {
        try {
            BufferedReader in =  new BufferedReader(new FileReader(fileName));
            String line = in.readLine();
            StringTokenizer tokens = new StringTokenizer(line);

            varNumber = Integer.parseInt(tokens.nextToken().trim());
            randomNumber = Integer.parseInt(tokens.nextToken().trim());
            minRandom =	Integer.parseInt(tokens.nextToken().trim());
            maxRandom =  Integer.parseInt(tokens.nextToken().trim());
            fitnessCases = Integer.parseInt(tokens.nextToken().trim());

            if (varNumber + randomNumber >= RANDOM_COUNT)
                System.out.println("too many variables and constants");

            targets = new int[fitnessCases][varNumber + 1];

            for (int i = 0; i < fitnessCases; i ++) {
                line = in.readLine();
                tokens = new StringTokenizer(line);
                for (int j = 0; j <= varNumber; j++)
                    targets[i][j] = Integer.parseInt(tokens.nextToken().trim());
            }

            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("ERROR: Please provide a data file");
            System.exit(0);
        }
        catch(Exception e) {
            System.out.println("ERROR: Incorrect data format");
            System.exit(0);
        }
    }

    void setupFitnessFunction(String path){
        try {
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

            List<String> optionList = new ArrayList<>();
            optionList.add("-classpath");
            optionList.add(System.getProperty("java.class.path") + File.pathSeparator + "dist/GPManager.jar");

            File fitnessFunctionJava = new File(path);
            Iterable<? extends JavaFileObject> compilationUnit = fileManager.getJavaFileObjectsFromFiles(List.of(fitnessFunctionJava));
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, optionList, null, compilationUnit);

            if (task.call()) {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("fitnessFunctions/./").toURI().toURL()});
                Class<?> loadedClass = classLoader.loadClass("FitnessFunction4");

                Object obj = loadedClass.newInstance();
                if (obj instanceof FitnessFunction) {
                    fitnessObj = (FitnessFunction)obj;
                }
            } else {
                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    System.out.format("Error on line %d in %s%n",
                            diagnostic.getLineNumber(),
                            diagnostic.getSource().toUri());
                }
            }

            fileManager.close();
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    void createRandomPopulation(double[] fitness) {
        for (int i = 0; i < POP_SIZE; i++) {
            Tree tree = createRandomTree();
            population.add(tree);
            fitness[i] = fitnessObj.fitnessFunction(runForAllInputs(tree), targets, varNumber);
        }
    }

    Tree createRandomTree() {
        Tree tree = new Tree();
        tree.grow();
        return tree;
    }

    List<List<Integer>> runForAllInputs(Tree tree) {
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> outputs = new ArrayList<>();

        for (int i = 0; i < fitnessCases; i ++) {
            for (int j = 0; j < varNumber; j++)
                input.add(targets[i][j]);

            outputs.add(tree.run(input));
            input.clear();
        }

        return outputs;
    }

    void evolve() {
        for (int gen = 1; gen < GENERATIONS; gen++) {
            double bestFitness = getBestFitness(null);
            if (bestFitness >= EPSILON) {
                System.out.print("PROBLEM SOLVED\n");
                System.exit(0);
            }

            for (int i = 0; i < POP_SIZE; i++) {
                Tree newTree = createNewTree();

                double newFit = fitnessObj.fitnessFunction(runForAllInputs(newTree), targets, varNumber);
                int offspring = negativeTournament(fitness);
                population.set(offspring, newTree);
                fitness[offspring] = newFit;
            }
        }

        System.out.print("PROBLEM *NOT* SOLVED\n");
        System.exit(1);
    }

    void evolve2(){
        for (int gen = 1; gen < GENERATIONS; gen++) {
            List<Tree> newPopulation = new ArrayList<>();
            double bestFitness = getBestFitness(newPopulation);

            if (bestFitness >= EPSILON) {
                System.out.print("PROBLEM SOLVED\n");
                System.exit(0);
            }

            for(int i = 0; i<250; i++)
                newPopulation.add(population.get(tournament()));

            for(int i = 0; i<250; i++)
                newPopulation.add(createRandomTree());

            while(newPopulation.size() < POP_SIZE) {
                Tree newTree = createNewTree();

                newPopulation.add(newTree);
            }

            population = newPopulation;
            for (int i = 0; i < POP_SIZE; i++)
                fitness[i] = fitnessObj.fitnessFunction(runForAllInputs(population.get(i)), targets, varNumber);
        }

        System.out.print("PROBLEM *NOT* SOLVED\n");
        System.exit(1);
    }

    Tree createNewTree(){
        Tree newTree;

        if (rd.nextDouble() < CROSSOVER_PROB) {
            int parent1 = tournament();
            int parent2 = tournament();
            newTree = crossover(population.get(parent1), population.get(parent2));
        }
        else {
            int parent = tournament();
            newTree = mutation(population.get(parent));
        }

        return newTree;
    }

    double getBestFitness(List<Tree> pop) {
        int randIndex = rd.nextInt(POP_SIZE);
        double bestFitness = fitness[randIndex];
        int best = randIndex;

        for (int i = 0; i < POP_SIZE; i++)
            if (fitness[i] > bestFitness) {
                bestFitness = fitness[i];
                best = i;
            }

        System.out.println(bestFitness);
        serializer.addToBuffer(bestFitness + ", ");
        population.get(best).root.serializeToTree(serializer);
        if(pop != null)
            pop.add(population.get(best).copy());

        return bestFitness;
    }

    int tournament() {
        int best = rd.nextInt(POP_SIZE), competitor;
        double fitnessBest = -1.0e34;

        for (int i = 0; i < T_SIZE; i++) {
            competitor = rd.nextInt(POP_SIZE);
            if (fitness[competitor] > fitnessBest) {
                fitnessBest = fitness[competitor];
                best = competitor;
            }
        }
        return best;
    }

    int negativeTournament(double[] fitness) {
        int worst = rd.nextInt(POP_SIZE), competitor;
        double fitnessWorst = 1e34;

        for (int i = 0; i < T_SIZE; i++) {
            competitor = rd.nextInt(POP_SIZE);
            if (fitness[competitor] < fitnessWorst) {
                fitnessWorst = fitness[competitor];
                worst = competitor;
            }
        }

        return worst;
    }

    Tree crossover(Tree parent1, Tree parent2) {
        Tree offspring = parent1.copy();
        offspring.crossover(parent2);
        return offspring;
    }

    Tree mutation(Tree parent) {
        Tree offspring = parent.copy();
        offspring.mutate();
        return offspring;
    }

    public interface FitnessFunction {
        double fitnessFunction(List<List<Integer>> outputs, int[][] targets, int varNumber);
    }
}