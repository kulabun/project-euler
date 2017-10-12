package euler;

/**
 * @author Konstantin Labun
 */
public class Euler12 {
    public static void main(String[] args) {
        long sum = 0;

        // 176576500
        for (int i = 1; i < 1_000_000_000; i++) {
            sum += i;
            int divisors = countDivisors(sum);

            System.out.println("i: " + i + ", sum = " + sum + ", divisors: " + divisors);
            if (divisors > 500) {
                System.out.println("The answer is:" + sum);
                return;
            }
        }
    }

    private static int countDivisors(long n) {
        int divisors = 2; // 1, n
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) divisors+=2;
        }
        return divisors;
    }
}
