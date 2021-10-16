import java.util.Scanner;

public class CountPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountPrimes countPrimes = new CountPrimes();
        int countPrimeNumbers = countPrimes.countPrimeNumbers(scanner.nextInt());
        System.out.println(countPrimeNumbers);
    }

    public int countPrimeNumbers(int n){
        boolean[] primes = new boolean[n];

        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if(primes[i]){
                for (int j = i; j * i < n; j++) {
                    primes[i * j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if(primes[i])
                count++;
        }
        return count;
    }
}
