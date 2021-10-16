public class NThTriBonacciNumber {
    public static void main(String[] args) {
        System.out.println(triBonacci(3));
    }

    static int[] cache = new int[38];
    public static int triBonacci(int n) {
        if (n == 0)
            return 0;
        else if (n <= 2)
            return 1;

        if (cache[n] != 0)
            return cache[n];
        else
            return cache[n] = triBonacci(n - 1) + triBonacci(n - 2) + triBonacci(n - 3);
    }

    public static int tribonacciNumber(int n){
        if (n == 0)
            return 0;
        else if (n <= 2)
            return 1;

        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i <= n; i++) {
            cache[i]  = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        return cache[n];
    }
}
