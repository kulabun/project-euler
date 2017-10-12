package euler;

/**
 * @author Konstantin Labun
 */
public class Euler17 {
    public static void main(String[] args) {
        String[] numbers = new String[1001];
        numbers[0] = "";
        numbers[1] = "one";
        numbers[2] = "two";
        numbers[3] = "three";
        numbers[4] = "four";
        numbers[5] = "five";
        numbers[6] = "six";
        numbers[7] = "seven";
        numbers[8] = "eight";
        numbers[9] = "nine";
        numbers[10] = "ten";
        numbers[11] = "eleven";
        numbers[12] = "twelve";
        numbers[13] = "thirteen";
        numbers[14] = "fourteen";
        numbers[15] = "fifteen";
        numbers[16] = "sixteen";
        numbers[17] = "seventeen";
        numbers[18] = "eighteen";
        numbers[19] = "nineteen";
        numbers[20] = "twenty";
        numbers[30] = "thirty";
        numbers[40] = "forty";
        numbers[50] = "fifty";
        numbers[60] = "sixty";
        numbers[70] = "seventy";
        numbers[80] = "eighty";
        numbers[90] = "ninety";
        numbers[100] = "one hundred";
        numbers[200] = "two hundred";
        numbers[300] = "three hundred";
        numbers[400] = "four hundred";
        numbers[500] = "five hundred";
        numbers[600] = "six hundred";
        numbers[700] = "seven hundred";
        numbers[800] = "eight hundred";
        numbers[900] = "nine hundred";
        numbers[1000] = "one thousand";

        for (int i = 21; i < 1000; i++) {
            if (i % 100 == 0 || (i < 100 && i % 10 == 0)) continue;
            int hundreds = (i / 100) * 100;
            int tens = ((i / 10) % 10) * 10;
            int tails = (i % 10);

            String hundredsStr = hundreds > 0 ? numbers[hundreds] + " and " : "";
            String tensStr = tens > 0 ? (tens == 10 && tails>0? "" : numbers[tens]) : "";
            String tailsStr = tails > 0 ?
                    (tens == 10 ? numbers[tens + tails]
                            : (tens > 10 ? "-" + numbers[tails] : numbers[tails]))
                    : "";

            numbers[i] = hundredsStr + tensStr + tailsStr;
        }

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) sb.append(number);

        int result = sb.toString().replaceAll("[ -]", "").length();
        System.out.println(result);
    }
}
