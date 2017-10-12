package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Konstantin Labun
 */
public class Euler4 {
    public static void main(String[] args) {
        final int START = 999;

        System.out.println(findMaxPalindrome(START));
    }

    private static int findMaxPalindrome(int START) {
        int largestPalindrome = 0;
        for (int i = START; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                int m = i * j;
                if(m < largestPalindrome) break;
                if (isPalindorme(m)) largestPalindrome = m;
            }
        }

        return largestPalindrome;
    }

    private static boolean isPalindorme(int number) {
        int reversed = 0;
        int n = number;
        while(n > 0) {
            reversed = 10 * reversed + n % 10;
            n /= 10;
        }
        return reversed == number;


//        String str = String.valueOf(number);
//        int half = str.length() / 2;
//        for (int i = 0; i <= half; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
//        }
//        return true;
    }
}
