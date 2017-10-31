package euler;

/**
 * @author Konstantin Labun
 */
public class Euler37 {
    public static void main(String[] args) {
        int counter = 0;
        int sum = 0;

        int number = 11;
        while (counter < 11) {
            if (isTruncatablePrime(number)) {
                counter++;
                sum += number;
//                System.out.println(number);
            }
            number++;
        }

        System.out.println(sum);
    }

    private static boolean isTruncatablePrime(int number) {
        if (!isPrime(number)) return false;

        int n = number;
        int newNum = 0;
        int counter = 0;
        while (n > 10) {
            newNum = newNum + (n % 10) * (int) Math.pow(10, counter++);
            n = n / 10;
            if (!isPrime(newNum) || !isPrime(n)) return false;
        }

        return true;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;
        if (n < 9) return true;

        int sqrt = (int) Math.sqrt(n);
        int k = 5;
        while (k <= sqrt) {
            if (n % k == 0) return false;
            if (n % (k + 2) == 0) return false;
            k += 6;
        }
        return true;
    }
}
