package algorithm.day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackDemo {

    static List<List<Integer>> res = new LinkedList<>();

    static Boolean[] vis;


    public static List<List<Integer>> permuteUnique(int[] nums) {

        vis = new Boolean[nums.length];

        Arrays.fill(vis, false);

        List<Integer> track = new LinkedList<>();

        Arrays.sort(nums);

        backTrack(nums, track, vis);

        return res;

    }

    private static void backTrack(int[] nums, List<Integer> track, Boolean[] vis) {

        // 结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])) {
                continue;
            }

            // 做选择
            vis[i] = true;
            track.add(nums[i]);

            backTrack(nums, track, vis);

            // 取消选择;
            track.remove(track.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {


        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));

    }

}
