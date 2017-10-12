package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler8 {
    public static void main(String[] args) {
        final String NUMBER = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";

        final int ADJ_NUM = 13;

        List<Short> window = new ArrayList<>();
        int pos = readWindow(window, NUMBER, 0, ADJ_NUM);

        long multiplexion = 1;
        long maxMulti = 0;

        while (pos < NUMBER.length() - 1) {
            pos = readWindow(window, NUMBER, pos, ADJ_NUM);
            System.out.println(pos);
            multiplexion = multiplex(window);
            if (maxMulti < multiplexion) maxMulti = multiplexion;
        }

        System.out.println(window);
        System.out.println(maxMulti);
    }

    private static int readWindow(List<Short> window, String number, int pos, int size) {
        if (window.size() == size) window.remove(0);
        while (pos < number.length() && window.size() < size) {
            Short digit = readNext(number, pos);
            if (digit == 0) window.clear();
            else window.add(digit);
            pos++;
        }
        return pos;
    }

    private static long multiplex(List<Short> factors) {
        long multiplex = 1;
        for (Short factor : factors) {
            multiplex *= factor;
        }
        return multiplex;
    }

    private static Short readNext(String NUMBER, int pos) {
        return Short.valueOf(NUMBER.substring(pos, pos + 1));
    }
}
