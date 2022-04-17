package algorithm.NumDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumDemo {

    public static int quickPow(int a, int b) {

        if (b == 0) {
            return 1;
        }

        // 根据奇偶性  讨论;
        if (b % 2 == 0) {
            int tmp = quickPow(a, b / 2);
            return tmp * tmp;
        } else {
            return quickPow(a, b - 1) * a;
        }

    }

    public static boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        // map建立映射关系; 左括号一定在右括号之前出现, 所以key 为右括号;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (map.containsKey(s.charAt(index))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(index))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(index));
            }
            index++;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        int a = 5, b = 7;

        String s = "{[(**)]}";

        System.out.println(isValid(s));



    }
}
