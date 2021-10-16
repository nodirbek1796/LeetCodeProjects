import java.util.Scanner;

public class AddDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(addDigits(scanner.nextInt()));
    }

    private static int addDigits(int number) {
        int result = 0;
        while (true){
            while (number > 0){
                result += number % 10;
                number /= 10;
            }
            if (result < 10)
                break;
            else {
                number = result;
                result = 0;
            }
        }
        return result;
    }

    public static int addDigitsEasyVersion(int number){
        if (number == 0)
            return 0;
        else if(number % 9 == 0)
            return 9;
        return number % 9;
    }
}
