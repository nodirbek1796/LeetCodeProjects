import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    private static void reverseString(char[] chars) {
        char temp;
        int length = chars.length - 1;
        for (int i = 0; i <= length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[length - i];
            chars[length - i] = temp;
        }
    }
}
