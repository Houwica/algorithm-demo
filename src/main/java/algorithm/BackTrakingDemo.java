package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class BackTrakingDemo {
    private static List<List<String>> res = new ArrayList<>();

    private static List<String> path = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private static void backtracking(String str, int startIndex) {
        if (startIndex == str.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < str.length(); i++) {

            String subStr = str.substring(startIndex, i + 1);

            if (!isPalinDrome(subStr)) {
                continue;
            } else {
                path.add(subStr);
            }

            backtracking(str, i + 1);

            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalinDrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // sum为当前子序列的最大和;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }

            sum += nums[i];

            max = Math.max(sum, max);
        }

        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int fstbuy = Integer.MIN_VALUE, fstsell = 0;
        int secbuy = Integer.MIN_VALUE, secsell = 0;
        for (Integer p : prices) {
            fstbuy = Math.max(fstbuy, -p);			// 第一次买 -p
            fstsell = Math.max(fstsell, fstbuy + p);	// 第一次卖 fstbut + p
            secbuy = Math.max(secbuy, fstsell - p);	// 第一次卖了后现在买 fstsell - p
            secsell = Math.max(secsell, secbuy + p);	// 第二次买了后现在卖 secbuy + p
        }

        return secsell;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(maxProfit(nums));
    }
}
