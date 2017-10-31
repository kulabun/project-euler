package euler;

/**
 * @author Konstantin Labun
 */
public class Euler40 {
    public static void main(String[] args) {
        int mul = 1;
        int counter = 0;
        int LIMIT = 1_000_000;
        int index = 1;

        int number = 1;
        while (index <= LIMIT) {
            int n = number;
            int digits = countDigits(number);
            int remains = number;
            while (remains > 0) {
                int tenPower = (int) Math.pow(10, digits - 1);
                int digit = n / tenPower;
                n = n - digit * tenPower;
                digits--;
                counter++;

                if (counter == index) {
                    System.out.println(digit + " is " + counter + "th");
                    mul *= digit;
                    index *= 10;
                }
                remains /= 10;
            }
            number++;
        }

        System.out.println(mul);
    }

    private static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
