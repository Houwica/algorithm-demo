package algorithm.day5;

import java.util.Random;

public class SortAlgorithm {

    public static int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] <= nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;

    }

    public static int[] selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minIndex] >= nums[j]) {
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        return nums;

    }

    public static int[] quickSort(int[] nums) {

        
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[1 << 16];

        Random r = new Random();
        for (int i = 0; i < 1 << 15; i++) {
            nums[i] = r.nextInt();
        }

        long startTime = System.currentTimeMillis();
        int[] res = bubbleSort(nums);

        long endTime = System.currentTimeMillis();


        System.out.println(endTime - startTime);
    }
}
