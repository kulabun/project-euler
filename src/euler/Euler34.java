package euler;

/**
 * @author Konstantin Labun
 */
public class Euler34 {
    public static void main(String[] args) {
//        System.out.println(factorial(9) * 6);
        int result = 0;
        for (int i = 3; i < 241920; i++) {
            if (summarizeDigitsFactorials(i) == i) result += i;
        }
        System.out.println(result);
    }

    private static int summarizeDigitsFactorials(int i) {
        int sum = 0;
        int n = i;
        while (n > 0) {
            sum += factorial(n % 10);
            n /= 10;
        }
        return sum;
    }

    public static long factorial(int n) {
        int result = 1;
        int counter = 2;
        while (counter <= n) {
            result *= counter;
            counter++;
        }
        return result;
    }
}
