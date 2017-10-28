package euler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Konstantin Labun
 */
public class Euler32 {
    public static void main(String[] args) {
        Set<Integer> products = new HashSet<>();
        for (int i = 100; i <= 9876; i++) {
            for (int j = 1; j <= 98; j++) {
                int mul = i * j;
                long concated = concat(mul, concat(i, j));
                if (concated >= 123456789 && concated <= 987654321 &&
                        isPandigital(concated)) products.add(mul);
            }
        }
        int sum = 0;
        for (Integer product : products) sum += product;

        System.out.println("Sum: " + sum);
    }

    private static long concat(long a, long b) {
        long tmp = b;
        while (tmp > 0) {
            tmp /= 10;
            a *= 10;
        }
        return a + b;
    }

    private static boolean isPandigital(long n) {
        int digits = 0;
        int count = 0;
        int tmp;

        while (n > 0) {
            if (n % 10 == 0) return false;
            tmp = digits;
            digits = digits | 1 << (int) ((n % 10) - 1);
            if (tmp == digits) {
                return false;
            }

            count++;
            n /= 10;
        }
        return digits == (1 << count) - 1;
    }
}
