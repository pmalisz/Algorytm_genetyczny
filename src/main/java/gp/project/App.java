package gp.project;

public class App
{
    public static void main( String[] args )
    {
        String fileName = "data/BOOL2XOR.txt";
        String fitnessFunctionFileName = "fitnessFunctions/FitnessFunction4.java";
        long seed = -1;

        if (args.length == 3) {
            seed = Integer.parseInt(args[0]);
            fileName = args[1];
            fitnessFunctionFileName = args[2];
        }
        if ( args.length == 2 ) {
            fileName = args[0];
            fitnessFunctionFileName = args[1];
        }

        if ( args.length == 1 ) {
            fitnessFunctionFileName = args[0];
        }

        GPManager gp = new GPManager(fileName, fitnessFunctionFileName, seed);
        gp.evolve2();
    }
}
