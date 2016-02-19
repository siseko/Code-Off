import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        final String FILE_DIR = "code_off-1/code_off-1.in";
//        final String FILE_DIR = "code_off-1/file";

        OutputStreamWriter out = new OutputStreamWriter(System.out);
        Scanner scanner = new Scanner(new File(FILE_DIR));
        String curVal;
        int length = Integer.valueOf(scanner.next());

        final ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            if (scanner.hasNext()) {
                strings.add(scanner.next());
            }
        }

        scanner.close();

        scanner = new Scanner(new File(FILE_DIR));
        scanner.next();

        for (int i = 0; i < length; i++) {
            if (scanner.hasNext()) {

                curVal = scanner.next();

                System.out.println(curVal);
                System.out.println(String.valueOf(isPalindrome(curVal)));

                for (int j = 0; j < strings.size(); j++) {
                    if (isEqualIgnoreSameString(curVal, strings.get(j))) {
                        System.out.println(strings.get(j));
                    }
                }
//            out.write(curVal);
//            out.write(String.valueOf(isPalindrome(curVal)));
            }
//        System.out.println(isEqualIgnoreSameString("Hi", "DBBBBD"));

        }
    }

    private static boolean isEqualIgnoreSameString(String curVal, String s) {
        return curVal.equals(s) ? false : evalSum(curVal) == evalSum(s);
    }

    static int evalSum(String value) {
        final char[] chars = value.toCharArray();

        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            if (isCapital(chars[i])) {
                sum += getValCapital(chars[i]);
            } else {
                sum += getValSmall(chars[i]);
            }
        }

//        System.out.println("sum " + sum);
        return sum;
    }

    static int getValCapital(char letter) {

        int offset = 64;

        return letter - offset;
    }

    static int getValSmall(char letter) {
        int offset = 98 - 1;
        return letter - offset;
    }

    static boolean isCapital(char letter) {
        return letter >= 64 && letter <= 96;
    }

    static boolean isPalindrome(String val) {
        return reverse(val).equals(val);
    }

    static String reverse(String val) {
        char[] chars = val.toCharArray();
        char[] reversed = new char[val.length()];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed[j] = chars[i];
            j++;
        }

        return String.copyValueOf(reversed);
    }
}
