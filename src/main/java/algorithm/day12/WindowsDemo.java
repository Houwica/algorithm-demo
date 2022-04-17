package algorithm.day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public class WindowsDemo {

    public static String minWindow(String s, String t) {
        int m = t.length(), n = s.length();

        Map<Character, Integer> needs = new HashMap();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needs.put(ch,  needs.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, match = 0, start = 0, minLen = Integer.MAX_VALUE;
        while (right < n) {
            if (needs.containsKey(s.charAt(right))) {
                char ch = s.charAt(right);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
            }

            // 统计数据满足要求时, 动态缩小窗口：
            while (left <= right && checkWindow(window, needs)) {


                // 记录每次满足条件的窗口数据;
                if (right - left < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // 更新滑动窗口的数据
                if (needs.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }

                left++;

            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);


    }

    /**
     * 校验滑动窗口的数值与目标窗口数据是否相等;
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean checkWindow(Map s, Map t) {
        Iterator iterator = t.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry)iterator.next();
            Character key = (Character) next.getKey();
            Integer value = (Integer) next.getValue();

            Integer sValue = (Integer) s.getOrDefault(key, 0);
            if (sValue < value) {
                return false;
            }

        }

        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() == 0){
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, right = 0;
        while(right < s.length()){
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);

            right++;

        }

        return maxLength;

    }

    public static double findMaxAverage(int[] nums, int k) {

        double res = 0.000000;
        int maxRes = Integer.MIN_VALUE;
        // 计算出首轮比较数据;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = 0 ; i < nums.length - k; i++) {
            int tmpSum = sum + nums[i + k] - nums[i];

            maxRes = Math.max(maxRes, tmpSum);
        }

        res = (double)maxRes / k;

        return res;
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {

        // 按绝对值大小排序; 便于寻找最小值;
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer:: intValue).toArray();

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if ( k > 0 && k % 2 != 0) {
            // 寻找此时的最小值;
            nums[nums.length - 1] = -nums[nums.length - 1];

        }


        return Arrays.stream(nums).sum();


    }

    public static void main(String[] args) {
        int[] nums = {5,6,9,-3,3};

//        int k = 4;
//
//        Arrays.sort(nums);
//
//        Arrays.stream(nums).forEach(e -> System.out.println(e));

        System.out.println(largestSumAfterKNegations(nums, 2));
    }

}
