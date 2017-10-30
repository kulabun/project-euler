package euler;

/**
 * @author Konstantin Labun
 */
public class Euler33 {

    public static void main(String[] args) {
        gcd(4, 6);

        // All with one digit same
        // i * 10 + j / i * 10 + k - never could be eq j/k
        // i * 10 + j / i + 10 * k - never could be eq j/k
        // i * 10 + j / j * 10 + k - only one possible case
        // i * 10 + j / j + 10 * k - never could be eq i/k

        int numerator = 1;
        int denominator = 1;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                int a = i * 10 + j;

                for (double k = 1; k < 10; k++) {
                    double b = j * 10 + k;

                    if (a / b < 1 && a / b == i / k) {
//                        System.out.println(a + "/" + (int) b);
                        numerator *= i;
                        denominator *= k;
                    }
                }
            }
        }

        int result = gcd(numerator, denominator);
        System.out.println(result);
    }

    private static int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }
}
