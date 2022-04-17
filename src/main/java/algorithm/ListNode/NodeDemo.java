package algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class NodeDemo {


    static class Node {
        private int val;

        private Node next;

        public Node(int val){
            this.val = val;
        }
    }

    /**
     * 链表的反转; 递归的解法, 迭代的解法;
     *
     *
     * @param head
     * @return
     */
    public static Node reverseListNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = reverseListNode(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public static Node swapPair(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        Node newNode = swapPair(next.next);

        // 节点的交换;
        next.next = head;
        head.next = newNode;

        return next;

    }

    public static void printListNode(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);

        printListNode(head.next);

    }


    public static void main(String[] args) {
        Node head = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node forth = new Node(3);
        head.next = second;
        second.next = third;
        third.next = forth;

        printListNode(reverseListNode(head));

        List<String> list = new ArrayList<>();


    }
}
