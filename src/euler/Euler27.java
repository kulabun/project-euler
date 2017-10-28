package euler;

/**
 * @author Konstantin Labun
 */
public class Euler27 {

    public static void main(String[] args) {
        boolean[] primes = calculatePrimes(1000);

        int targetA = 0;
        int targetB = 0;
        int max = -1;
        for (int sign = -1; sign <= 1; sign += 2) {
            for (int a = -999; a < 1000; a++) {
                int lastPrime = 0;
                while(lastPrime != -1) {
                    lastPrime = nextPrime(primes, lastPrime);
                    int b = sign * lastPrime;
                    int primesCount = countPrimes(a, b);

                    if (max < primesCount) {
                        max = primesCount;
                        targetA = a;
                        targetB = b;
                    }
                }
            }
        }

        System.out.println("a: " + targetA + ", b: " + targetB + ", prime count: " + max);
        System.out.println("Product: " + targetA * targetB);
    }

    private static int countPrimes(int a, int b) {
        int n = 0;
        while (isPrime(n * n + a * n + b)) n++;
        return n;
    }

    private static int nextPrime(boolean[] primes, int start) {
        if (start > 997) return -1;

        int j = start + 1;
        while (!primes[j]){
            if(j > 997) return -1;
            j++;
        }
        return j;
    }

    private static boolean[] calculatePrimes(int limit) {
        boolean[] primes = new boolean[limit];
        for (int i = 1; i < limit; i++) {
            if (isPrime(i)) primes[i] = true;
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;
        if (n < 9) return true;

        int sqrt = (int) Math.sqrt(n);
        int k = 5;
        while (k <= sqrt) {
            if (n % k == 0) return false;
            if (n % (k + 2) == 0) return false;
            k += 6;
        }
        return true;
    }
}
