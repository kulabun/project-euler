package euler;

/**
 * @author Konstantin Labun
 */
public class Euler38 {

    public static void main(String[] args) {
        long number = 987654321 / 2;

        long max = findMaxPandigitalMultiplies(number);

        System.out.println(max);
    }

    private static long findMaxPandigitalMultiplies(long number) {
        while (number > 0) {
            long result = number;
            long mul = 2;
            while (mul <= 9 && size(result) < 9) {
                result = concat(result, mul * number);
                mul++;
            }
            if (mul > 2 && isPandigital(result)) return result;
            number--;
        }
        return -1;
    }

    private static long size(long number) {
        long size = 0;
        while (number > 0) {
            number = number / 10;
            size++;
        }
        return size;
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
        long digits = 0;
        long count = 0;
        long tmp;

        while (n > 0) {
            if (n % 10 == 0) return false;
            tmp = digits;
            digits = digits | 1 << ((n % 10) - 1);
            if (tmp == digits) {
                return false;
            }

            count++;
            n /= 10;
        }
        return digits == (1 << count) - 1;
    }
}
