package euler;

/**
 * @author Konstantin Labun
 */
public class Euler21 {

    public static void main(String[] args) {
        final int LIMIT = 10_000;

        int[] sums = new int[LIMIT];
        for (int i = 3; i < LIMIT; i++) {
            int number = calculateDivisorsSum(i);
            if (number > LIMIT) continue;
            sums[i] = number;
        }

        int result = 0;
        for (int i = 0; i < LIMIT; i++) {
            if (sums[i] < LIMIT
                    && i == sums[sums[i]]
                    && i != sums[i]) result += i;
        }

        System.out.println(result);
    }

    private static int calculateDivisorsSum(int number) {
        int sum = 1;

        if (sum % 2 == 0) sum += 2;
        int limit = number / 2;
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) sum += i;
        }
        return sum;
    }
}
