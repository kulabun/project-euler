package euler;

import java.math.BigInteger;

/**
 * @author Konstantin Labun
 */
public class Euler16 {
    public static void main(String[] args) {
        BigInteger NUMBER = BigInteger.valueOf(2).pow(1000);

        int sum = 0;
        String numStr = NUMBER.toString();
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.valueOf(numStr.substring(i, i + 1));
        }

        System.out.println(sum);
    }
}
