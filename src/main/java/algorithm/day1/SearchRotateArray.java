package algorithm.day1;

public class SearchRotateArray {


    public static int search(int[] nums, int target) {
        int res = -1;
        if (nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target){
               return mid;
            }

            // 判断哪一段是否为有序数组
            if ( nums[right] < nums[mid]) {
                // 左边为有序数组
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 有边为有序数组
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int row = matrix.length, column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (target <= matrix[i][column - 1]) {
                return  (binarySearch(matrix[i], target));
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        boolean res = false;

        if (nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) /2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                return true;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 13;

        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix, target));

    }
}
