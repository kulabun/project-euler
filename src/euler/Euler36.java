package euler;

/**
 * @author Konstantin Labun
 */
public class Euler36 {
    public static void main(String[] args) {
        int LIMIT = 1_000_000;
        int sum = 0;
        for (int i = 0; i < LIMIT; i++) {
            if(isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) sum+=i;
        }
        System.out.println(sum);
    }

    public static boolean isPalindrome(String str) {
        int center = str.length() / 2;
        for (int i = 0; i < center; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}
