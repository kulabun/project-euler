package euler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler24 {

    public static void main(String[] args) {
//        String result = calculate(Arrays.asList("0", "1", "2"), 5);
        long start = System.currentTimeMillis();
        String result = calculate(Arrays.asList("0", "1", "2", "3","4","5","6","7","8","9"), 1_000_000);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Done in " + (end - start) + "ms");
    }

    private static String calculate(List<String> symbols, int interestNumber) {
        int[] numbers = calculatePermutationsNumbersForDifferentStringLengths(symbols);

        List<String> freeSymbols = new LinkedList<>(symbols);
        String result = "";
        int remains = interestNumber - 1;
        int index = symbols.size() - 1;
        while (remains >= 0 && index >= 0) {
            int num = numbers[index--];
            int sum = 0;
            int currentMultiplier = 0;
            if (num != 0) {
                while (sum + num <= remains) {
                    sum += num;
                    currentMultiplier++;
                }
            }
            result += freeSymbols.remove(currentMultiplier);
            remains = remains - sum;
        }
        return result;
    }

    private static int[] calculatePermutationsNumbersForDifferentStringLengths(List<String> symbols) {
        int number = 1;
        int counter = 0;
        int[] numbers = new int[symbols.size()];
        while (++counter < numbers.length) {
            number *= counter;
            numbers[counter] = number;
        }
        return numbers;
    }
}
