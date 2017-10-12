package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler3 {
    public static void main(String[] args) {
        long LIMIT = 600851475143L;
        List<Long> factors = new ArrayList<>();

        long result = LIMIT;
        if (result % 2 == 0) {
            factors.add(2L);
            result = result / 2;
        }

        long factor = 3;
        long sqrt = sqrt(LIMIT);
        while (result > 1) {
            if(factor > sqrt) {
                factors.add(LIMIT);
                break;
            }

            if (result % factor == 0) {
                factors.add(factor);
                result = result / factor;
            }
            factor++;
        }


        System.out.println(factors);
        Long m = 1L;
        for (Long f : factors) {
            m *= f;
        }
        System.out.println(LIMIT - m);
        System.out.println(m == LIMIT);

//        int sqrt = sqrt(LIMIT);
//        for (long i = 2; i < sqrt; i++)
//            if (factors.isEmpty() || checkPrime(factors, i)) factors.add(i);
//
//        System.out.println(factors.get(factors.size() - 1));
    }

    private static int sqrt(long LIMIT) {
        int x = 1;
        while (Math.pow(x, 2) < LIMIT) x++;
        return x;
    }

    private static boolean checkPrime(List<Long> primes, long i) {
        for (Long prime : primes) {
            if (i % prime == 0) return false;
        }
        System.out.println("prime found: " + i);
        return true;
    }
}
