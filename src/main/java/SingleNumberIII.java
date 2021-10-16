import java.util.HashSet;
import java.util.Iterator;

public class SingleNumberIII {
    public static void main(String[] args) {

    }

    public static int[] singleNumber(int[] numbers){
        int[] result = new int[2];
        HashSet<Integer> integers = new HashSet<>();
        boolean status;

        for (int number : numbers) {
            status = integers.add(number);
            if (!status)
                integers.remove(number);
        }

        int i = 0;
        for (Integer integer : integers) {
            result[i++] = integer;
        }

        return result;
    }
}
