package euler;

/**
 * @author Konstantin Labun
 */
public class Euler23 {
    static final int LIMIT = 28123;

    public static void main(String[] args) {
        sumOfDivisors(9);

        long start = System.currentTimeMillis();
        boolean[] abundants = getAbundantsMap();
        boolean[] abundantSums = abundantBitMap(abundants);

        int sum = 0;
        for (int i = 0; i <= LIMIT; i++) {
            if (!abundantSums[i]) sum += i;
        }

        long runtime = System.currentTimeMillis() - start;

        System.out.println("Answer: " + sum);
        System.out.println("Finished in " + runtime);
    }

    private static boolean[] abundantBitMap(boolean[] abundants) {
        boolean[] abundantSums = new boolean[LIMIT + 1];

        for (int i = 0; i <= LIMIT; i++) {
            if (!abundants[i]) continue;
            for (int j = i; j <= LIMIT; j++) {
                if (!abundants[j]) continue;

                Integer sum = i + j;
                if (sum > LIMIT) break;

                abundantSums[sum] = true;
            }
        }
        return abundantSums;
    }

    private static boolean isAbundant(int n) {
        return (sumOfDivisors(n) > n + n);
    }

    private static int sumOfDivisors(int n) {
        int prod = 1;
        for (int k = 2; k * k <= n; k++) {
            int p = 1;
            while (n % k == 0) {
                p = p * k + 1;
                n /= k;
            }
            prod *= p;
        }
        if (n > 1)
            prod *= 1 + n;
        return prod;
    }

    private static boolean[] getAbundantsMap() {
        boolean[] abundantNumbers = new boolean[LIMIT + 1];
        for (int i = 12; i <= LIMIT; i++) {
            abundantNumbers[i] = isAbundant(i);
        }
        return abundantNumbers;
    }
}
