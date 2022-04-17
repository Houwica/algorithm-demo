package algorithm.day2;

public class SearchMinInRotateArray {


    public static int findMin(int[] nums) {
        int res = -1;
        if (nums.length == 0) {
            return res;
        }

        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] < nums[index]) {
                res = index + 1;

                return nums[index + 1];
            }
            index++;
        }

        return nums[0];
    }

    /**
     * 可转化为求局部最大值和全局最大值
     *
     * 双指针法求数组的最大值：时间复杂度（O(logN)）
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {

        int res = -1;
        if (nums.length == 0) {
            return res;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {

            if (nums[left] <= nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        if (nums[left] > nums[right]) {
            return left;
        } else {
            return right;
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }

        int left = 0;

        while (left < nums.length ) {
            int right = left + 1;
            while (right < nums.length) {
                if (nums[left] + nums[right] == target) {
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
                right++;
            }
            left++;
        }


        return res;     
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};


        int[] nums = new int[]{3, 2, 4};

        System.out.println(twoSum(nums, 6)[0]);

        System.out.println(twoSum(nums, 6)[1]);

    }
}
