package algorithm.day6;

public class SlideWindowsDemo {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, ans = Integer.MAX_VALUE, right = 0, sums = 0;
        while (right < nums.length) {
            sums += nums[right++];

            while (sums >= target) {
                ans = Math.min(ans, right - left);
                sums -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1) {
            return 0;
        }
        int left = 0, right = 0, ans = 0, sums = 1;
        for (; right < nums.length; right++) {
            sums *= nums[right];

            while (sums >= k) {
                sums /= nums[left++];
            }

            ans += right - left + 1;

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int target = 100;




        System.out.println(numSubarrayProductLessThanK(nums, target));
    }
}
