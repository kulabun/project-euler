package euler;

/**
 * @author Konstantin Labun
 */
public class Euler2 {
    public static void main(String[] args) {
        int prev = 1;
        int cur = 1;
        int next;
        int sum = 0;
        while (cur < 4_000_000) {
            next = prev + cur;
            prev = next + cur;
            cur = next + prev;
            sum += next;
        }

        System.out.println(sum);
    }
}
