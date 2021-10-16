import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindromeString("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindromeString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = word.length();
        String lowerCase = word.toLowerCase();
        char charAt;
        for (int i = 0; i < length; i++) {
            charAt = lowerCase.charAt(i);
            if (Character.isAlphabetic(charAt) || Character.isDigit(charAt))
                stringBuilder.append(charAt);
        }
        int length1 = stringBuilder.length();
        for (int i = 0, j = length1 - 1; i < length1 / 2; i++, j--) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(j))
                return false;
        }
        return true;
    }
}
