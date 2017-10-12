package euler;

/**
 * @author Konstantin Labun
 */
public class Euler10 {
    public static void main(String[] args) {
        long sum = 2 + 3;

        // all primes greater then 3 are equals to 6k+/-1
        for (int i = 5; i < 2_000_000; i += 6) {
            if (isPrime(i)) sum += i;
            if (isPrime(i + 2)) sum += (i + 2);
        }

        System.out.println(sum);
    }

    private static boolean isPrime(long n) {
        if (n == 1) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        if (n < 9) return true;
        if (n % 3 == 0) return false;

        long sqrt = Double.valueOf(Math.floor(Math.sqrt(n))).longValue();
        long f = 5;
        while (f <= sqrt) {
            if (n % f == 0) return false;
            if (n % (f + 2) == 0) return false;
            f += 6;
        }

        return true;
    }
}
