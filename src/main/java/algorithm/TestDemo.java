package algorithm;

import com.alibaba.fastjson.JSON;
import javafx.util.Pair;
import org.apache.commons.net.util.SubnetUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestDemo {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // bfs, 借用队列, 遍历时判断是否在边界内
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 队列记录坐标位置
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int flag = grid[row][col];
        grid[row][col] = color;

        // 记录边界数据
        List<int[]> borders = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            int[] curNode = queue.poll();
            Boolean isBorder = false;
            for (int i = 0; i < moves.length; i++) {
                int a = moves[i][0] + curNode[0];
                int b = moves[i][1] + curNode[1];
                if (!(inArea(grid, a, b) && grid[a][b] == flag)) {
                    isBorder = true;
                } else if (!visited[a][b]) {
                    queue.add(new int[]{a, b});
                    visited[a][b] = true;
                }
            }

            if (isBorder) {
                borders.add(new int[]{curNode[0], curNode[1]});
            }
        }

        for (int i = 0; i < borders.size(); i++) {

            int x = borders.get(i)[0];
            int y = borders.get(i)[1];

            grid[x][y] = color;
        }


        return grid;
    }

    private static boolean inArea(int[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            return true;
        }

        return false;
    }

    public static int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 当全为陆地或海洋时, 返回
        if (queue.isEmpty() || queue.size() == N) {
            return -1;
        }

        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int count = queue.size();
            while (count > 0) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] move : moves) {
                    int r2 = move[0] + r;
                    int c2 = move[1] + c;
                    if (inArea(r2, c2, N) && grid[r2][c2] == 0) {
                        // 以陆地为基准, 遍历附近的海洋区域;
                        queue.add(new int[]{r2, c2});
                        grid[r2][c2] = 2;
                    }
                }
                count--;
            }
        }

        return distance;
    }

    public static int findLHS(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return res;
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[right] - nums[left] > 1) {
                right--;
            } else if (nums[right] - nums[left] == 1) {
                return right - left + 1;
            } else {
                return 0;
            }
        }

        return res;
    }


    private static boolean inArea(int r, int c, int N) {
        if (r >= 0 && r < N && c >= 0 && c < N) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // 相等且含有重复的元素
        boolean flag = false;
        if (s.equals(goal)) {
            int[] hashtable = new int[2696];
            for (int i = 0; i < s.length(); i++) {
                hashtable[s.charAt(i) - 'a']++;
                if (hashtable[s.charAt(i) - 'a'] > 1) {
                    flag = true;
                    break;
                }
            }
        }

        int index = 0, cnt = 0;
        int[] nums = new int[]{0, 0};
        while (index < s.length()) {
            if (s.charAt(index) != goal.charAt(index)) {
                nums[cnt] = index;
                cnt++;
            }

            if (cnt > 1) {
                return false;
            }
            index++;
        }

        if (cnt == 0 && flag) {
            return true;
        }

        if (cnt == 1) {
            return false;
        }


        // 比较具有2处相等的情况;
        if (cnt == 2 && s.charAt(nums[0]) == goal.charAt(nums[1]) && s.charAt(nums[1]) == goal.charAt(nums[0])) {
            return true;
        }

        return false;

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1), cur = new ListNode();
        dummy.next = stack.pop();
        cur = dummy.next;

        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            cur.next = node;
            cur = cur.next;
        }

        cur.next = null;

        return dummy.next;
    }

    public static String modifyString(String s) {

        char[] arr = s.toCharArray();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if ('?' == arr[i]) {
                char ch = 'a';
                // 每替换一次, 改变一次对应的替换值;
                while ((i > 0 && arr[i - 1] == ch) ||
                        (i < n - 1 && arr[i + 1] == ch)) {
                    ch++;
                }

                arr[i] = ch;
            }
        }

        return String.valueOf(arr);
    }

    public static char setRule(char ch) {
        char res = 'a';
        if (ch == 'z') {
            res = (char) (ch - 1);
        } else if (ch == 'a') {
            res = (char) (ch + 1);
        } else {
            res = (char) (ch + 1);
        }

        return res;
    }

    public static boolean jumpGame(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    private static boolean check(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'A') {
                upper[ch - 'A'] = true;
            }
        }

        return Arrays.equals(lower, upper);
    }


    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                if (isPalindrome(subStr) && subStr.length() > ans.length()) {
                    ans = subStr;
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String s) {

        System.out.println(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }


    static final int[] nums = {
            1, 2, 3, 5, 8,
            13, 21, 34, 55, 89,
            144, 233, 377, 610, 987,
            1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025,
            121393, 196418, 317811, 514229, 832040,
            1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986,
            102334155, 165580141, 267914296, 433494437, 701408733
    };



    public static int findMinFibonacciNumbers(int k) {

        int[] test = new int[12];

        int ans = 0;

        while(k > 0)
        {
            int low = 0;
            int high = nums.length;
            while(low < high)
            {
                int mid = (low + high) >> 1;
                if(nums[mid] > k) high = mid;
                else low = mid + 1;
            }
            k -= nums[low-1];
            ans ++;
        }


        return ans;
    }


    public static String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1;

        StringBuilder res = new StringBuilder();
        int cur = 0;
        while (indexA >= 0 || indexB >= 0) {

            int sum = cur;
            sum += indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            sum += indexB >= 0 ? b.charAt(indexB) - '0' : 0;

            res.append(sum % 2);

            cur = sum / 2;

            indexA--;
            indexB--;
        }



        res.append(cur == 1 ? '1' : "");


        return res.reverse().toString();
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int slowIndex = 0;

        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex] = nums[fastIndex] ^ nums[slowIndex];
                nums[fastIndex] = nums[fastIndex] ^ nums[slowIndex];
                nums[slowIndex] = nums[fastIndex] ^ nums[slowIndex];

                slowIndex++;
            }

        }
    }


    /**
     * params = 214;
     *
     * @param s
     * @return
     */
    private static int strToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                break;
            }

            nums = nums * 10 + s.charAt(i) - '0';
        }

        return nums;
    }


    public static String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        int calNum = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (calNum > 0) {
            sb.append(calNum % 7);

            calNum = calNum / 7;
        }

        if (num < 0) {
            return "-" + sb.toString();
        } else  {
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        SubnetUtils subnetUtils = new SubnetUtils("192.168.77.0/24");
        subnetUtils.setInclusiveHostCount(true);

        SubnetUtils.SubnetInfo info = subnetUtils.getInfo();


        System.out.println(info.getLowAddress());

        System.out.printf(info.getHighAddress());

    }

    private static boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

            return true;
        }



        return false;
    }
}
