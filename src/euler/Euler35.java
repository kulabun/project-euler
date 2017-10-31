package euler;

/**
 * @author Konstantin Labun
 */
public class Euler35 {
    public static void main(String[] args) {
        int LIMIT = 1_000_000;
        int counter = 2; // 2, 3
        for (int i = 5; i < LIMIT; i += 6) {
            if (isCircularPrime(i)) counter++;
            if (isCircularPrime(i + 2)) counter++;
        }
        System.out.println(counter);
    }

    public static boolean isCircularPrime(int i) {
        int digits = countDigits(i);
        int n = i;
        int pushs = digits;
        while (--pushs >= 0) {
            n = n / 10 + (int) Math.pow(10, (digits - 1)) * (n % 10);
            if (!isPrime(n)) return false;
        }
        return true;
    }

    private static int countDigits(int i) {
        int digits = 1;
        while (i / 10 > 0) {
            i = i / 10;
            digits++;
        }
        return digits;
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
