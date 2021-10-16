package arrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(3);

        arrayList.insert(15);
        arrayList.insert(9);
        arrayList.insert(10);
        arrayList.insert(110);
        arrayList.insert(14);
        arrayList.insert(55);

        arrayList.print();

        System.out.println(arrayList.size());
    }
}
