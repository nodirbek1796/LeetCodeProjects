public class DataStructure {
    public static void main(String[] args) {
        int n = 100, m = 70;
//        for (int i = 2; i < 100; i++) {
//            System.out.println("Hello World! " + i);
//        }
//        for (int i = 2; i < Math.sqrt(n); i++) {
//            System.out.println("Hello World! " + i);
//        }
        int[] numbers = new int[n];
        // O(1)
        System.out.println(numbers[0]);
        
        // O(1) + O(1) = O(2) = O(1)
        System.out.println(numbers[0]);
        System.out.println(numbers[0]);

        // O(n)
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // O(1) + O(n) + O(1) = O(n + 2) = O(n)
        System.out.println(numbers[0]);
        for (int i = 0; i < numbers.length; i++) 
            System.out.println(numbers[i]);
        System.out.println(numbers[0]);

        // O(n) + O(n) = O(2n) = O(n)   bu holatda ham koeffitsientni tashlab yuborishimiz mumkin!
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
        
        String[] names = new String[m];
        
        // O(n) + O(m) = O(n + m) = O(n)
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i]);

        // O(n) * O(n) = O(n * n) = O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(numbers[i] + numbers[j]);
            }
        }

        // O(n) * O(n) + O(n) = O(n * n + n) = O(n^2 + n) = O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(numbers[i] + numbers[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }

        // O(n) * O(n) * O(n) = O(n * n * n) = O(n^3)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println(numbers[i] + numbers[j]);
                }
            }
        }

        int target = 10;

        // O(n) worst case ga nisbatan shunday javob olinadi...
        for (int i = 0; i < n; i++) {   // linear search
            if (target == numbers[i])
                System.out.println(i);
        }

        // Binary search


        // Space complexity
        int a = 100;                // O(1)
        int[] nums = new int[a];    // O(n)
        int b = 50;                 // O(1) -> Umumiy time complexity O(1) + O(n) + O(1) = O(n)

    }
}
