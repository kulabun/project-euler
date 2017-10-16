package euler;

/**
 * @author Konstantin Labun
 */
public class Euler19 {
    public static void main(String[] args) {
        int total = 0;
        int result = 1;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                total += countDaysInMonth(year, month);
                if (total % 7 == 0) result++;
            }
        }
        System.out.println(result);
    }

    private static int countDaysInMonth(int year, int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        if (month == 2) return (isLeapYear(year) ? 29 : 28);
        return 31;
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
