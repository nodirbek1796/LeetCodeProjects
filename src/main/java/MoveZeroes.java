import java.util.Scanner;

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    // 100 %
    public static void moveZeros(int [] nums){
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0, j = 0; i < length; i++) {
            if (nums[i] != 0)
                result[j++] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
    }

    // in here we first shift no zero values to the left
    // then assign zero value to right elements...
    // 100 %
    public static void moveZerosThird(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
