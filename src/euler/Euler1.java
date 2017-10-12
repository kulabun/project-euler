package euler;

import java.util.stream.IntStream;

/**
 * @author Konstantin Labun
 */
public class Euler1 {
    public static void main(String[] args) {
        final int LIMIT = 1000;

        int sum3 = summarize(3, LIMIT);
        int sum5 = summarize(5, LIMIT);
        int sum15 = summarize(15, LIMIT);

        int sum = sum3 + sum5 - sum15;
        System.out.println(sum);

        if(validAnswer(LIMIT) != sum) System.out.println("Invalid answer!");
    }

    private static int validAnswer(int LIMIT) {
        return IntStream.range(1, LIMIT)
                .filter(it -> it % 3 == 0 || it % 5 == 0)
                .sum();
    }

    private static int summarize(int step, int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i += step) {
            sum += i;
        }
        return sum;
    }
}
