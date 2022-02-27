package SecondTaskInNUU;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    private static DecimalFormat df = new DecimalFormat("#.####");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float resultOfFunction;

        int[][] givenObjects = readObjectsFromBreastCancerFile();

        System.out.println("Given objects: ");
        for (int[] givenObject : givenObjects) {
            for (int v : givenObject) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // in here I find out the amount of classes ...
        int[] classNumbers = new int[givenObjects.length];

        for (int i = 0; i < givenObjects.length; i++) {
            classNumbers[i] = givenObjects[i][givenObjects[0].length - 1];
        }

        float amountOfFirstClass = calculate(classNumbers);
        float amountOfSecondClass = givenObjects.length - amountOfFirstClass;

        float chosenNumber;
        float classNumber;

        float[][] realValueOfObjects = new float[givenObjects.length][givenObjects[0].length];

        for (int i = 0; i < givenObjects[0].length - 1; i++) {
            for (int j = 0; j < givenObjects.length; j++) {

                chosenNumber = givenObjects[j][i];
                classNumber = givenObjects[j][givenObjects[0].length - 1];

                // alomat qiymatining mos klasslarda nechta ekanlagini sanash
                // uchun mazkur sanagichlardan foydalandim ...
                float countX_In_Class_1 = 0;
                float countX_In_Class_2 = 0;

                for (int[] givenObject : givenObjects) {
                    if (givenObject[i] == chosenNumber)
                        if (givenObject[givenObjects[0].length - 1] == 2)
                            countX_In_Class_1++;
                        else
                            countX_In_Class_2++;
                }

                if (classNumber == 2){
                    resultOfFunction = countX_In_Class_1 / amountOfFirstClass /
                            (countX_In_Class_1 / amountOfFirstClass + countX_In_Class_2 / amountOfSecondClass);
                }
                else
                    resultOfFunction = countX_In_Class_2 / amountOfSecondClass /
                            (countX_In_Class_2 / amountOfSecondClass + countX_In_Class_1 / amountOfFirstClass);
                realValueOfObjects[j][i] = resultOfFunction;
            }
        }

        for (int i = 0; i < givenObjects.length; i++) {
            realValueOfObjects[i][givenObjects[0].length - 1] = givenObjects[i][givenObjects[0].length - 1];
        }

        System.out.println("\n\n******     Berilgan tanlanmaning miqdoriy qiymatlari:     ******\n\n");
        for (float[] realValueOfObject : realValueOfObjects) {
            for (int j = 0; j < realValueOfObjects[0].length; j++) {
                System.out.print(df.format(realValueOfObject[j]) + "\t\t");
            }
            System.out.println();
        }

        int k = 1;
        while (k != 0){

            if (k > realValueOfObjects.length)
                throw new IllegalArgumentException("k is not in possible option!");

            System.out.print("\nk = ");
            k = scanner.nextInt();

            float totalAmountOfAccuracy = 0;

            for (int i = 0; i < realValueOfObjects.length; i++) {

                // bu yerda biz tanlamaning bir qismini ajratib olyapmiz
                float[][] baseNumbers = getBaseNumbers(realValueOfObjects, i);

                float accuracyOfTestObjects = calculateAccuracyOfTestObjects(realValueOfObjects[i], baseNumbers, k);
                totalAmountOfAccuracy += accuracyOfTestObjects;
            }
            System.out.println("k = " + k + ",\t\tAnglash aniqligi: " + totalAmountOfAccuracy * 100/ givenObjects.length + "%");
        }
    }

    private static float[][] readObjectsFromDogAndWolfFile(){
        float[][] objectsFromDogAndWolfFile = new float[42][7];
        try {
            File myObj = new File("src/main/java/SecondTaskInNUU/IT_BORI.txt");
            Scanner myReader = new Scanner(myObj);
            int rowsOrder = 0;
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().replace(",", ".").split(" ");
                for (int i = 0; i < split.length; i++) {
                    objectsFromDogAndWolfFile[rowsOrder][i] = Float.parseFloat(split[i]);
                }
                rowsOrder++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return objectsFromDogAndWolfFile;
    }

    private static float[][] readObjectsFromFile(){
        float[][] objects = new float[100][5];
        try {
            File myObj = new File("src/main/java/SecondTaskInNUU/iris.txt");
            Scanner myReader = new Scanner(myObj);
            int rowsOrder = 0;
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().split(",");
                if (rowsOrder == 100)
                    break;
                for (int i = 0; i < split.length; i++) {
                    if (i == split.length - 1)
                        if (split[i].equals("Iris-setosa"))
                            objects[rowsOrder][i] = 1;
                        else
                            objects[rowsOrder][i] = 2;
                    else
                        objects[rowsOrder][i] = Float.parseFloat(split[i]);
                }
                rowsOrder++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return objects;
    }

    private static int[][] readObjectsFromBreastCancerFile(){
        int[][] breastCancerObjects = new int[699][10];
        int helper;
        try {
            File myObj = new File("src/main/java/SecondTaskInNUU/breast-cancer-wisconsin.data");
            Scanner myReader = new Scanner(myObj);
            int rowsOrder = 0;
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().split(",");
                for (int i = 0, j = 0; i < split.length; i++) {
                    if (i == 0)
                        continue;
                    try {
                        helper = Integer.parseInt(split[i]);
                    }catch (NumberFormatException e){
                        helper = 1;
                    }
                    breastCancerObjects[rowsOrder][j++] = helper;
                }
                rowsOrder++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return breastCancerObjects;
    }

    // berilgan tanlanmada klasslar sonini aniqlash funksiyasi ...
    private static int calculate(int[] classNumbers){
        int countFirstClass = 0;
        for (float classNumber : classNumbers) {
            if (classNumber == 2)
                countFirstClass++;
        }
        return countFirstClass;
    }

    /**
     * Mazkur method tanlanmaning muayyan bittasini ajratib qolgan obyektlarni esa boshqa bir
     * array ga yig'ib orqaga qaytarish uchun xizmat qiladi.
     * @param numbers float numbers
     * @param i int bu parameter aynan qaysi obyektni ajratib olish kerakligini ifodalaydi
     * @return float ortga yana float type dagi raqamlarni qaytaramiz
     */
    private static float[][] getBaseNumbers(float[][] numbers, int i){
        int lengthOfRows = numbers.length - 1;
        int lengthOfColumns = numbers[0].length;

        float[][] baseNumbers = new float[lengthOfRows][lengthOfColumns];

        int row = 0;
        int baseNumbersRow = 0;
        while (baseNumbersRow != lengthOfRows){
            int column = 0;
            if (row == i)
                row++;
            for (int j = 0; j < lengthOfColumns; j++) {
                baseNumbers[baseNumbersRow][column] = numbers[row][column];
                column++;
            }
            baseNumbersRow++;
            row++;
        }
        return baseNumbers;
    }

    /**
     * Mazkur method ajratib olingan obyektga nisbatan qolgan obyektlarning orasidagi masofani hisoblaydi
     * va ortga klass tartib raqami va orasidagi masofani o'zida ifodalovchi (ClassOrderAndDistance)
     * ortga ArrayList ga yig'ib qaytaradi.
     * @param testObject ajratib olingan obyekt
     * @param baseObject tekshirish uchun qolgan obyektlar to'plami
     * @return ArrayList
     */
    private static ArrayList<ClassOrderAndDistance> calculateDistance(float[] testObject, float[][] baseObject){
        double helper;
        float classOrder;
        ArrayList<ClassOrderAndDistance> arrayList = new ArrayList<>();

        for (float[] floats : baseObject) {
            helper = 0;
            for (int j = 0; j < baseObject[0].length - 1; j++) {
                helper += Math.pow((testObject[j] - floats[j]), 2);
            }
            classOrder = floats[baseObject[0].length - 1];
            ClassOrderAndDistance classOrderAndDistance =
                    new ClassOrderAndDistance(classOrder, (float) Math.sqrt(helper));
            arrayList.add(classOrderAndDistance);
        }

        bubbleSort(arrayList, arrayList.size());

        return arrayList;
    }

    private static ArrayList<ClassOrderAndDistance> calculateDistanceByJuravlev(float[] testObject, float[][] baseObject){
        double helper;
        float classOrder;
        ArrayList<ClassOrderAndDistance> arrayList = new ArrayList<>();

        for (float[] floats : baseObject) {
            helper = 0;
            for (int j = 0; j < baseObject[0].length - 1; j++) {
                helper += Math.pow((testObject[j] - floats[j]), 2);
            }
            classOrder = floats[baseObject[0].length - 1];
            ClassOrderAndDistance classOrderAndDistance =
                    new ClassOrderAndDistance(classOrder, (float) Math.sqrt(helper));
            arrayList.add(classOrderAndDistance);
        }

        bubbleSort(arrayList, arrayList.size());

        return arrayList;
    }

    public static void bubbleSort(ArrayList<ClassOrderAndDistance> arrayList, int n)
    {
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (arrayList.get(i).getDistance() > arrayList.get(i + 1).getDistance())      //check if the elements are in order
            {                           //if not, swap them
                ClassOrderAndDistance temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(i + 1));
                arrayList.set(i + 1, temp);
            }
        }

        bubbleSort(arrayList, n-1);           //one pass done, proceed to the next
    }

    private static float calculateAccuracyOfTestObjects(float[] testObject, float[][] trainingObject, int k){
        int testObjectClassNumber = (int)testObject[testObject.length - 1];
        float accuracy;

        ArrayList<ClassOrderAndDistance> arrayList = calculateDistance(testObject, trainingObject);

        int countFirstClass = 0;
        int countSecondClass = 0;
        for (int i = 0; i < k; i++) {
            if (arrayList.get(i).getClassOrder() == 2)
                countFirstClass++;
            else
                countSecondClass++;
        }

        accuracy = (testObjectClassNumber == 2 ? (float) countFirstClass / k : (float) countSecondClass / k);

        return accuracy;
    }

    private static int juravlevMetrics(int[] testObject, int[] trainingObject){
        int result = 0;
        float epsilon = 0.001f;
        for (int i = 0; i < testObject.length; i++) {
            int abs = Math.abs(testObject[i] - trainingObject[i]);
            if (abs < epsilon)
                result++;
        }
        return result;
    }
}
