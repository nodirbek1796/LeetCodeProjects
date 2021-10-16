import java.util.Scanner;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validPerfectSquare = isValidPerfectSquare(scanner.nextInt());
        System.out.println(validPerfectSquare);
    }

    public static boolean isValidPerfectSquare(int number){
        return Math.sqrt(number) % 1 == 0;
    }

    public static boolean isValid(int number){
        int i = 1;
        while (number > 0){
            number -= i;
            i += 2;
        }
        return number == 0;
    }

    // performed by binary search
    public static boolean isValidBySearch(int number){
        long start = 1, end = number,middle, result;
        while(start <= end){
            middle = start + (end - start) / 2;
            result = middle * middle;
            if (result == number)
                return true;
            else if(result < number)
                start = middle + 1;
            else
                end = middle - 1;
        }
        return false;
    }

    public static boolean isValidByNewton(int number){
        long x = number;
        while (x * x > number){
            x = (x + number / x) / 2;
        }
        return x == number;
    }
}
