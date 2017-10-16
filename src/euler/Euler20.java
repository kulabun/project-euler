package euler;

import java.math.BigInteger;

/**
 * @author Konstantin Labun
 */
public class Euler20 {
    public static void main(String[] args) {
        final int N = 100;
        BigInteger factorial = factorial(N);
        System.out.println(summarizeDigits(factorial));
    }

    private static BigInteger factorial(int n) {
        BigInteger number = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        return number;
    }

    private static int summarizeDigits(BigInteger number) {
        int sum = 0;
        String numStr = number.toString();
        for (int i = 0; i < numStr.length(); i++) {
            sum += numStr.charAt(i) - '0';
        }
        return sum;
    }
}
