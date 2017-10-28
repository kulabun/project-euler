package euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Konstantin Labun
 */
public class Euler29 {
    public static void main(String[] args) {
        int LOW_LIMIT = 2;
        int HIGH_LIMIT = 100;
        Set<BigInteger> numbers = new HashSet<>((HIGH_LIMIT - LOW_LIMIT + 1) * (HIGH_LIMIT - LOW_LIMIT + 1));
        for (int a = LOW_LIMIT; a <= HIGH_LIMIT; a++) {
            for (int b = LOW_LIMIT; b <= HIGH_LIMIT; b++) {
                numbers.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.println(numbers.size());
    }
}
