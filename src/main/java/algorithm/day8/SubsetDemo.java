package algorithm.day8;

import javax.xml.stream.events.Characters;
import java.util.*;

public class SubsetDemo {

    public static boolean[] vis;

    public static List<List<Integer>> subset(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        // 明白track的真实作用;
        List<Integer> track = new ArrayList<>();

        vis = new boolean[nums.length];
        Arrays.fill(vis, Boolean.FALSE);

        dfs(nums, vis, track, res);

        return res;
    }

    public static void dfs(int[] nums, boolean[] vis, List<Integer> track,List<List<Integer>> res) {

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == false) {
                continue;
            }

            vis[i] = true;
//            dfs(nums, vis, );
        }

    }

    /**
     * 子集的暴力解法，每遍历一个元素，向已输出子集中添加改元素；
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subnetForce(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subnets = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                List<Integer> meta = new ArrayList<>(res.get(j));
                meta.add(nums[i]);
            }

            res.addAll(subnets);
        }

        return res;
    }

    int res = 0;
    public int countSubstrings(String s) {
        List<Character> track = new LinkedList();

//        dfs(s.toCharArray(), track);

        return res;

    }


    private void dfs(char[] arr, List<Characters> track){
        if (track.size() == arr.length){
            res++;
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if (track.contains(arr[i]))
                continue;

//            track.add(arr[i]);
            dfs(arr, track);
            track.remove(track.size() - 1);
        }

    }

    private boolean isPalindrome(String s){
        if (s.length() == 1){
            return true;
        }

        int left = 0, right = s.length() - 1;
        while(left < right){
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isContainsSameChar(String s, String t) {
        int[] charS = new int[26], charT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charS[i] > 0 && charT[i] > 0) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
//
//        int length = nums.length;
//
//        Stack<Integer> stack = new Stack<>();
//
//        String s = "1";
//
//        s.length();
//
//        List<Character> characters = new ArrayList<>();
//
//        char[] chars = s.toCharArray();
//
//        System.out.println(subnetForce(nums));

        System.out.println(isContainsSameChar("abcg", "tta"));
    }
}
