import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isRotatedString(scanner.nextLine(), scanner.nextLine()));
    }

    private static boolean isRotatedString(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length())
            return false;
        firstWord += firstWord;
        return firstWord.contains(secondWord);
    }
}
