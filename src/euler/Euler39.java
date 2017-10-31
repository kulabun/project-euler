package euler;

/**
 * @author Konstantin Labun
 */
public class Euler39 {
    public static void main(String[] args) {
        final int LIMIT = 1000;
        int max = 0;
        int value = 0;
        for (int p = 2; p < LIMIT; p += 2) {
            int solutionsCounter = 0;
            for (int b = 0; b < p / 3; b++) {
                int a = p * (2 * b - p) / (2 * (b - p));
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(p - a - b, 2)) solutionsCounter++;
            }
            if(max < solutionsCounter) {
                value= p;
                max = solutionsCounter;
            }
        }

        System.out.println(value + " with " + max + " solutions");
    }
}
