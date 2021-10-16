public class PowerOfThree {
    public static void main(String[] args) {

    }

    public static boolean powerOfThree(int number){
        long i = 1;
        while (i < number){
            i *= 3;
        }
        return i == number;
    }
}
