package euler;

/**
 * http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#section2
 *
 * @author Konstantin Labun
 */
public class Euler25_2 {
    private static final double SQRT_5 = Math.sqrt(5);
    private static final double PHI_LOG = Math.log10((SQRT_5 + 1) / 2);

    public static void main(String[] args) {
        System.out.println(calculate(1000));
    }

    private static int calculate(int digitsNumber) {
        int start = 4 * 1000; // every new digit appended either on +4 or +5 incremention
        int end = 5 * 1000;

        int current = start;
        while (current++ < end && countDigits(current) < digitsNumber) continue;

        return current;
    }

    private static long countDigits(int i) {
        return Math.round(i * PHI_LOG - Math.log10(SQRT_5));
    }
}
