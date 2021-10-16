public class GreenWhiteSolution {
    public static void main(String[] args) {
        System.out.println(div(18, 10));
        System.out.println(mod(10, 2));
        System.out.println(sum(1542));
    }

    public static int div(int a, int b){
        if (a < b)
            return 0;
        return (1 + div(a - b, b));
    }

    public static int mod(int a, int b){
        if (a < b)
            return a;
        return mod(a - b, b);
    }

    public static int sum(int n){
        if (n < 10)
            return n;
        return mod(n, 10 ) + sum(div(n, 10));
    }

    public static int fibonacci(int n){
        if(n < 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciSecond(int n, int m){
        if(n < 2)
            return m;
        return fibonacciSecond(n - 1, m) + fibonacciSecond(n - 2, m);
    }
}
