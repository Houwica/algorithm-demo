package algorithm.day3;

import java.util.Stack;

public class DoublePointerDemo {

    public static boolean backspaceCompare(String s, String t) {

        // 堆栈法;
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        char[] charS = s.toCharArray();

        for (Character ch : charS) {
            if (ch == '#') {
                if (!stackS.empty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(ch);
            }
        }

        char[] charT = t.toCharArray();
        for (Character ch : charT) {
            if (ch == '#') {
                if (!stackS.empty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(ch);
            }
        }

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }

        }

        if (stackS.isEmpty() && stackT.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * 双指针方案
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean doublePointerSolution(String s, String t) {
        int skipS = 0, skipT = 0;
        int indexS = s.length() - 1, indexT = t.length() - 1;

        // 倒序遍历数组
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        while (indexS >= 0 && indexT >= 0) {


        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 删除升序链表中重复元素：通过双指针操纵链表结构的改变;
     *
     * @param head
     * @return
     */
    static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // dummy节点, 作为返回值,
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
                cur = cur.next;

            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        // 双指针疗法, 实际的指针一般不作为返回值
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(4);
        ListNode sixth = new ListNode(4);
        ListNode seventh = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;



//        while (cur != null) {
//            if (cur.val == 3) {                                                                                          
//                pre.next = cur.next;
//            } else {
//                pre = pre.next;
//            }
//
//            cur = cur.next;
//        }

        ListNode res = deleteDuplicates(first);


        printListNode(res);
//


    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
