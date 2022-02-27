package notebook;

public class WorkBook {
    public static void main(String[] args) {
        int[] numbers = {10, 15, 7, 3, 1};
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        bubbleSort(numbers, numbers.length);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void bubbleSort(int arr[], int n)
    {
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (arr[i] > arr[i+1])      //check if the elements are in order
            {                           //if not, swap them
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, n-1);           //one pass done, proceed to the next
    }
}
