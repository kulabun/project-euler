package euler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Konstantin Labun
 */
public class Euler18 {
    public static void main(String[] args) {
        String INPUT =
                "75\n" +
                        "95 64\n" +
                        "17 47 82\n" +
                        "18 35 87 10\n" +
                        "20 04 82 47 65\n" +
                        "19 01 23 75 03 34\n" +
                        "88 02 77 73 07 63 67\n" +
                        "99 65 04 28 06 16 70 92\n" +
                        "41 41 26 56 83 40 80 70 33\n" +
                        "41 48 72 33 47 32 37 16 94 29\n" +
                        "53 71 44 65 25 43 91 52 97 51 14\n" +
                        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        Integer[] arr = readArray(INPUT);
        int pos = arr.length - 1;
        int deepness = getDeepness(arr);
        int currentDeepness = deepness;
        Node[] nodes = new Node[arr.length];
        do {
            int rowStart = Math.max(pos - currentDeepness + 1, 0);
            while (pos >= rowStart) {
                Node left = getNode(pos + currentDeepness, nodes);
                Node right = getNode(pos + currentDeepness + 1, nodes);
                nodes[pos] = new Node(arr[pos], left, right);
                pos--;
            }
        } while (--currentDeepness > 0);
        System.out.println(nodes[0].maxSum);
    }

    private static Node getNode(int i, Node[] nodes) {
        if (i < nodes.length) {
            return nodes[i];
        }
        return null;
    }

    private static int getDeepness(Integer[] arr) {
        int counter = 1;
        int sum = 0;
        while (sum + counter < arr.length) {
            sum += counter;
            counter++;
        }
        return counter;
    }

    private static Integer[] readArray(String INPUT) {
        Scanner sc = new Scanner(INPUT);
        ArrayList<Integer> arr = new ArrayList<>();
        while (sc.hasNext()) arr.add(sc.nextInt());
        return arr.toArray(new Integer[arr.size()]);
    }

    static class Node {
        final int value;
        final int maxSum;
        final Node left;
        final Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.maxSum = calculateMaxSum(value, left, right);
        }

        private int calculateMaxSum(int value, Node left, Node right) {
            if (left != null && right != null) {
                return value + Math.max(left.maxSum, right.maxSum);
            }
            return value;
        }
    }
}
