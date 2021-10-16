import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isAnagram(scanner.nextLine(), scanner.nextLine()));
    }

    public static boolean isAnagram(String firstWord, String secondWord){
        if (firstWord.length() != secondWord.length())
            return false;

        char[] chars = firstWord.toCharArray();
        char[] chars1 = secondWord.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chars1);

        firstWord = Arrays.toString(chars);
        secondWord = Arrays.toString(chars1);

        return firstWord.equals(secondWord);
    }

    public static boolean isAnagramThirdVersion(String firstWord, String secondWord){
        int length = firstWord.length();
        if (length != secondWord.length())
            return false;

        int[] count = new int[26];
        Arrays.fill(count, 0);

        for (int i = 0; i < length; i++) {
            count[firstWord.charAt(i) - 'a']++;
            count[secondWord.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;
    }
}
