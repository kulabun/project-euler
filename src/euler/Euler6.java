package euler;

/**
 * @author Konstantin Labun
 */
public class Euler6 {
    public static void main(String[] args) {
        final int LIMIT = 100;

        int sumOfsquared = 0;

        for (int i = 1; i <= LIMIT; i++) {
            sumOfsquared += i * i;
        }

        int sum = getSum(LIMIT);
        long squareOfSum = sum * sum;

        System.out.println(squareOfSum - sumOfsquared);
    }

    private static int getSum(int n) {
        return n * (n + 1) / 2;
    }
}
