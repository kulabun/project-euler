package euler;

/**
 * @author Konstantin Labun
 */
public class Euler9 {
    public static void main(String[] args) {
        System.out.println(getProduct(1000));
    }

    private static int getProduct(int number) {
        for (int a = 1; a < number / 2; a++) {
            for (int b = a; b < number / 2; b++) {
                System.out.println("a:" + a + ", b:" + b);
                if (a + b - a * b / number == number / 2)
                    return a * b * (int) Math.sqrt(a * a + b * b);
            }
        }
        throw new RuntimeException("no product found");
    }
}
