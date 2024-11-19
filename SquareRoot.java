/**
 * Darius Fan
 * COMS W3134
 * Programming Assignment 1 - Square Root
 * 9/11/24
 */
public class SquareRoot
{
    public static final double EPSILON = 1e-7;

    public static double sqrt(double num, double epsilon)
    {
        if (num == Double.NaN || num < 0)
        {
            return Double.NaN;
        }
        if (num == 0 || num == Double.POSITIVE_INFINITY)
        {
            return num;
        }

        double currentGuess = num;
        double previousGuess = Double.POSITIVE_INFINITY;
        while (Math.abs(currentGuess - previousGuess) > epsilon)
        {
            previousGuess = currentGuess;
            currentGuess = 0.5 * (previousGuess + (num / previousGuess));
        }
        return currentGuess;
    }

    public static void main(String[] args)
    {
        if (args.length == 1 || args.length == 2)
        {
            double value = 0;
            try
            {
                value = Double.parseDouble(args[0]);
            }
            catch (NumberFormatException e)
            {
                System.err.println("Error: Value argument must be a double.");
                System.exit(1);
            }

            if (args.length == 2)
            {
                double epsilon = 0;
                try
                {
                    epsilon = Double.parseDouble(args[1]);
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Error: Epsilon argument must be a positive double.");
                    System.exit(1);
                }
                if (epsilon <= 0)
                {
                    System.err.println("Error: Epsilon argument must be a positive double.");
                    System.exit(1);
                }
                System.out.printf("%.8f%n", sqrt(value, epsilon));
                System.exit(0);
            }
            System.out.printf("%.8f%n", sqrt(value, EPSILON));
            System.exit(0);
        }
        System.err.println("Usage: java SquareRoot <value> [epsilon]");
        System.exit(1);
    }
}