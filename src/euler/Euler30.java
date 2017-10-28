package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler30 {
    public static void main(String[] args) {
        int POWER = 5;
        long max = (long) Math.pow(9, 5);
        long maxNumber = calculateMaxPossibleNumber(max);

        List<Long> numbers = new ArrayList<>();
        for (long i = 2; i < maxNumber; i++) {
            if (isEqToPowersOfDigits(i, POWER)) numbers.add(i);
        }

        long sum = numbers.stream().mapToLong(Long::longValue).sum();
        System.out.println(sum);
    }

    private static long calculateMaxPossibleNumber(long max) {
        int counter = 0;
        while (String.valueOf(max * counter).length() >= counter) counter++;
        return max * (counter - 1);
    }

    private static boolean isEqToPowersOfDigits(long number, int power) {
        int sum = 0;
        long n = number;
        while (n > 0) {
            sum += Math.pow(n % 10, power);
            n = n / 10;
        }
        return sum == number;
    }
}
