package algorithm.StringDemo;

import java.util.ArrayList;
import java.util.List;

public class CharCntDemo {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] cnt = new int[26];

        for (char ch : magazine.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (--cnt[ch - 'a'] < 0) {
                return false;
            }

        }

        return true;

    }

    public static int findString(String[] words, String s) {
        int l = 0, h = words.length - 1;
        while(l <= h) {
            int  m = l+(h-l)/2;
            //就比平常代码多了下面这一行
            while((m > l) && (words[m] == "")) { m--;}
            if(words[m] == s) return m;
            else if(words[m].compareTo(s) < 0) l=m+1;
            else if(words[m].compareTo(s) > 0) h = m - 1;
        }
        return -1;
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char ch : s.toCharArray()) {
            rows.get(i).append(ch);

            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }

            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }

        return res.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {

        String a = "abcdef";
        String target = "ab";

        char ch = 'k';

        int[][] nums = {{1, 1}};
        int n = nums.length;
        int m = nums[0].length;

        String[] strs = new String[]{"flower", "fly", "flight"};



        System.out.println(longestCommonPrefix(strs));

    }

}
