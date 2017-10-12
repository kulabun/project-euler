package euler;

/**
 * @author Konstantin Labun
 */
public class Euler14 {
    public static void main(String[] args) {
        int LIMIT = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println(getCollatzSequenceLength(LIMIT));
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(getCollatzSequenceLength2(LIMIT));
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int getCollatzSequenceLength2(int LIMIT) {
        int[] lengths = new int[LIMIT];
        for (int i = 1; i < lengths.length; i++) {
            long seqNum = i;
            while (seqNum != 1) {
                if (seqNum < i) {
                    lengths[i] += lengths[(int) seqNum];
                    break;
                }
                seqNum = nextCollatz(seqNum);
                lengths[i]++;
            }
        }

        int max = 0;
        int number = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > max) {
                max = lengths[i];
                number = i;
            }
        }
        return number;
    }

    private static long nextCollatz(long seqNum) {
        if (seqNum % 2 == 0) seqNum = seqNum / 2;
        else seqNum = 3 * seqNum + 1;
        return seqNum;
    }

    private static int getCollatzSequenceLength(int LIMIT) {
        int maxLen = 0;
        int number = 0;
        for (int i = 1; i < LIMIT; i++) {
            int len = 0;
            long seqNum = i;

            while (seqNum != 1) {
                seqNum = nextCollatz(seqNum);
                len++;
            }

            if (maxLen < len) {
                maxLen = len;
                number = i;
            }
        }
        return number;
    }
}
