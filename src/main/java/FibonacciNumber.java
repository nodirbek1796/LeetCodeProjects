public class FibonacciNumber {
    public static void main(String[] args) {

    }

    public static int findFibonacciNumber(int n){
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;
        return findFibonacciNumber(n - 1) + findFibonacciNumber(n - 2);
    }

    public static int fibonacciNumber(int n){
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;
        int previousNumber = 0;
        int nextNumber = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        return sum;
    }

    // By Dynamic programming
    public static int findFibonacciNumberTopDown(int n){    // or memoization
        int [] cache = new int[31];
        if (n <= 1)
            return n;
        if (cache[n] != 0)
            return cache[n];
        else
            return cache[n] = findFibonacciNumberTopDown(n - 1) + findFibonacciNumberTopDown(n - 2);
    }

    public static int findFibNumberBottomUp(int n){
        if (n <= 1)
            return n;

        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
