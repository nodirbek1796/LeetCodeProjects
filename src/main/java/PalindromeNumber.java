public class PalindromeNumber {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(int number){
        if (number < 0 || (number % 10 == 0 && number > 0))
            return false;
        int temp = number;
        int reverseFormOfNumber = 0;
        while (number > 0){
            reverseFormOfNumber =  reverseFormOfNumber * 10 + number % 10;
            number /= 10;
        }
        return reverseFormOfNumber == temp;
    }
}
