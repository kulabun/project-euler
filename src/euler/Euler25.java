package euler;

import java.math.BigInteger;

/**
 * @author Konstantin Labun
 */
public class Euler25 {

    public static void main(String[] args) {
        BigInteger prev = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        int index = 2;
        while (current.toString().length() != 1000) {
            BigInteger next = current.add(prev);
            prev = current;
            current = next;
            index++;
        }

        System.out.println(index);
    }
}
