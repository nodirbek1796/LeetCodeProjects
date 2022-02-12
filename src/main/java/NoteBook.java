import SecondTaskInNUU.ClassOrderAndDistance;

import java.util.ArrayList;
import java.util.Scanner;

public class NoteBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ClassOrderAndDistance> arrayList = new ArrayList<>();

        arrayList.add(new ClassOrderAndDistance(1, 7));
        arrayList.add(new ClassOrderAndDistance(1, 10));
        arrayList.add(new ClassOrderAndDistance(1, 2));
        arrayList.add(new ClassOrderAndDistance(1, 2));
        arrayList.add(new ClassOrderAndDistance(1, 4));

        System.out.println(arrayList);

        arrayList.sort((o1, o2) -> (int) (o1.getDistance() - o2.getDistance()));
        System.out.println(arrayList);
    }
}
