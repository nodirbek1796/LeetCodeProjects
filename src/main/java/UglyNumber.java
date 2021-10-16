import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isUglyNumber(scanner.nextInt()));
    }

    private static boolean isUglyNumber(int number) {
        if(number == 1)
            return true;
        if (number == 0)
            return false;
        while (true){
            if (number % 2 == 0)
                number /= 2;
            else if(number % 3 == 0)
                number /= 3;
            else if(number % 5 == 0)
                number /= 5;
            else
                break;
        }
        return number == 1;
    }
}
