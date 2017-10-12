package euler;

/**
 * @author Konstantin Labun
 */
public class Euler7 {
    public static void main(String[] args) {
        int LIMIT = 10_001;

        long n = findNPrime(LIMIT);
        System.out.println(n);
    }

    private static long findNPrime(int LIMIT) {
        long n = 1;
        int counter = 1;
        while (counter != LIMIT) {
            n+=2;
            if (isPrime(n)) counter++;
        }
        return n;
    }

    private static boolean isPrime(Long n) {
        if (n == 1) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        if (n < 9) return true;
        if (n % 3 == 0) return false;
        long sqrt = Double.valueOf(Math.floor(Math.sqrt(n))).longValue();
        int f = 5;
        while (f <= sqrt) {
            if (n % f == 0) return false;
            if (n % (f + 2) == 0) return false;
            f += 6;
        }
        return true;
    }
}
