package euler;

/**
 * @author Konstantin Labun
 */
public class Euler26 {

    public static void main(String[] args) {
        final int LIMIT = 1000;
        int max = 0;
        int result = 0;
        for (int i = 2; i < LIMIT; i++) {
            boolean[] remainders = new boolean[i];
            int remainder = 1;
            while (!remainders[remainder]){
                remainders[remainder] = true;
                remainder = (remainder * 10) % i;
            }

            int counter = countTrue(remainders);

            if (counter > max) {
                max = counter;
                result = i;
            }
        }
        System.out.println(result + " with longest cycle  " + max);
    }

    private static int countTrue(boolean[] remainders) {
        int counter = 0;
        for (boolean r : remainders) if (r) counter++;
        return counter;
    }
}
