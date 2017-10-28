package euler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler31 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

        int TARGET_SUM = 200;

        runBruteforce(coins, TARGET_SUM);
        runOptimized(coins, TARGET_SUM);
    }

    private static void runOptimized(int[] coins, int TARGET_SUM) {
        long start = System.currentTimeMillis();
        int counter = optimized(coins, TARGET_SUM);
        long end = System.currentTimeMillis();
        System.out.println(counter);
        System.out.println("Done in " + (end - start) + "ms");
    }

    private static int optimized(int[] coins, int target_sum) {
        Arrays.sort(coins);

        int[] memo = new int[target_sum + 1];
        for (int coin : coins) {
            for (int i = coin; i <= target_sum; i++) {
                if (i == coin) memo[i]++;
                memo[i] += memo[Math.max(0, i - coin)];
            }
        }
        return memo[target_sum];
    }

    private static void runBruteforce(int[] coins, int TARGET_SUM) {

        long start = System.currentTimeMillis();
        int counter = bruteforce(coins, TARGET_SUM);
        long end = System.currentTimeMillis();
        System.out.println(counter);
        System.out.println("Done in " + (end - start) + "ms");
    }

    private static int bruteforce(int[] coins, int TARGET_SUM) {
        int counter = 0;
        List<Integer> sums = new LinkedList<>();
        sums.add(0);
        int depth = 0;

        for (int i = depth; i < coins.length; i++) {
            LinkedList<Integer> sumsToIter = new LinkedList<>(sums);
            for (Integer sum : sumsToIter) {
                int coin = coins[i];
                int localSum = sum;
                while (localSum + coin < TARGET_SUM) {
                    localSum = localSum + coin;
                    sums.add(localSum);
                }
                if (localSum + coin == TARGET_SUM) counter++;
                depth++;
            }
        }
        return counter;
    }
}
