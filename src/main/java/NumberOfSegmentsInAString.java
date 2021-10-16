import java.util.Scanner;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countSegments(scanner.nextLine()));
    }

    private static int countSegments(String word) {
        String[] s = word.split(" ");
        return s.length;
    }
}
