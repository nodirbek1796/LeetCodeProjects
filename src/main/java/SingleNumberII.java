import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumberII {
    public static void main(String[] args) {
        int [] numbers = {2,2,3,2};
        System.out.println(singleNumber(numbers));
    }

    public static int singleNumber(int[] numbers) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int temp;
        Integer put;

        for (int number : numbers) {
            temp = number;
            put = hashMap.put(temp, 1);
            if (put != null)
                hashMap.replace(temp, 1, 2);
        }

        AtomicInteger result = new AtomicInteger();
        hashMap.forEach((integer, integer2) -> {
            if (integer2 == 1) {
                result.set(integer);
            }
        });
        return result.get();
    }

    public static int singleNumberByArrayList(int[] numbers){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int number : numbers) {
            arrayList.add(number);
        }
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.indexOf(numbers[i]) == arrayList.lastIndexOf(numbers[i])) {
                result = numbers[i];
                break;
            }
        }
        return result;
    }
}
