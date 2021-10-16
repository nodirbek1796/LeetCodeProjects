import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPerfectNumber(scanner.nextInt()));
    }

    private static boolean isPerfectNumber(int number) {
        if (number == 1)
            return false;
        int sum = 1;
        int square = (int)Math.sqrt(number);
        for (int i = 2; i <= square; i++) {
            if (number % i == 0) {
                sum += i;
                sum += number / i;
            }
        }
        return sum == number;
    }
}
