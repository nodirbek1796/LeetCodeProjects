import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new  int[n];
        System.out.println(findUniqueNumber(numbers));
    }

    private static int findUniqueNumber(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i += 2) {
            if (numbers[i] != numbers[i + 1])
                return numbers[i];
        }
        return numbers[numbers.length - 1];
    }

    private static int findUniqueNumberByHashMap(int[] numbers){
        int temp = 0;
        for (int number : numbers) {
            temp ^= number;
        }
        return temp;
    }
}
