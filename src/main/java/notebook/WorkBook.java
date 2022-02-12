package notebook;

import java.util.HashSet;

public class WorkBook {
    public static void main(String[] args) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        System.out.println(uniqueNumbers.add(10));
        System.out.println(uniqueNumbers.add(10));
    }
}
