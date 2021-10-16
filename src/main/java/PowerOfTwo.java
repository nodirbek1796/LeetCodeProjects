public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(536870912));
    }

    public static boolean powerOfTwo(int number){
        if(number == 1)
            return true;
        if(number <= 0 || number % 2 == 1)
            return false;
        double result = (Math.log10(number) / Math.log10(2));
        return result % 1 == 0;
    }
}
