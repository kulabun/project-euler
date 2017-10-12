package euler;

import java.math.BigInteger;

/**
 * @author Konstantin Labun
 */
public class Euler15 {
    public static void main(String[] args) {
        int SIZE = 20;
        System.out.println(countCombintations(SIZE));
    }

    private static BigInteger countCombintations(int sz) {
        return factorial(2 * sz).divide(factorial(sz).multiply(factorial(sz)));
    }

    private static BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
