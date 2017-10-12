package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler5 {
    public static void main(String[] args) {
        int TARGET_NUMBER = 20;


        long result = 1;
        List<Integer> factors = getFactors(TARGET_NUMBER);
        for (Integer factor : factors) {
            result *= factor;
        }

        System.out.println(factors);
        System.out.println(result);
    }

    private static List<Integer> getFactors(int TARGET_NUMBER) {
        List<Integer> factors = getPrimes(TARGET_NUMBER);


        for (int i = 0; i < factors.size(); i++) {
            int x = factors.get(i);
            int num = x;
            while (num * x < TARGET_NUMBER) num = num * x;
            factors.set(i, num);
        }
        return factors;
    }

    private static List<Integer> getPrimes(int TARGET_NUMBER) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < TARGET_NUMBER; i += 2) {
            if (isPrime(primes, i)) primes.add(i);
        }
        return primes;
    }

    private static boolean isPrime(List<Integer> primes, int i) {
        for (Integer prime : primes) {
            if (i % prime == 0) return false;
        }
        return true;
    }
}
