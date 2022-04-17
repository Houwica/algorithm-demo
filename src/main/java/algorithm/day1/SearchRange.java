package algorithm.day1;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0)
            return res;

        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);

        return res;
    }

    private static int binarySearch(int[] nums, int target, boolean fromLeft) {
        int res = -1;
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
                res = mid;
                if (fromLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 10, 10};

        int target = 8;

        int[] res = searchRange(nums, target);

        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
