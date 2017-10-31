package euler;

/**
 * @author Konstantin Labun
 */
public class Euler41 {
    private static boolean[] PRIMES = new boolean[987654321];

    public static void main(String[] args) {
        System.out.println(calculateMaxPrimePandigital());
    }

    private static int calculateMaxPrimePandigital() {
        PRIMES = sieve(PRIMES);

        for (int i = PRIMES.length - 1; i >= 0; i--) {
            if (!PRIMES[i] && isPandigital(i)) return i;
        }

        return 0;
    }

    private static boolean[] sieve(boolean[] primes) {
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) continue;
            int index = i * 2;
            while (index < primes.length) {
                primes[index] = true;
                index += i;
            }
        }
        return primes;
    }

    private static boolean isPandigital(long n) {
        long digits = 0;
        long count = 0;
        long tmp;

        while (n > 0) {
            if (n % 10 == 0) return false;
            tmp = digits;
            digits = digits | 1 << ((n % 10) - 1);
            if (tmp == digits) {
                return false;
            }

            count++;
            n /= 10;
        }
        return digits == (1 << count) - 1;
    }
}
