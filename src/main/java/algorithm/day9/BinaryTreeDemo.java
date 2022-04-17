package algorithm.day9;

import java.util.*;

import static java.util.Collections.reverse;

public class BinaryTreeDemo {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(){}

    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        preOrder(root.left);

        preOrder(root.right);

    }

    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);

    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                tmp.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(tmp);
        }

        return res;
    }

    /**
     * 前中后序遍历，隐含的使用系统的栈空间, 所以在结上比宽度优先搜索方法代码更简洁
     *
     * @param root
     */
    public void depthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        depthFirstSearch(root.left);
        depthFirstSearch(root.right);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 双端队列的使用;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            // 记录遍历的层级;
            List<Integer> list = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                list.add(node.val);
                count--;
            }

            if (level % 2 == 0) {
                reverse(list);
            }
            res.add(list);
            level++;
        }

        return res;
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;


        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();

            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                if (count == 1) {
                    res.add(node.val);
                }
                count--;
            }

        }

        return res;

    }


    public static int maxDepth(TreeNode root){
        int level = 0;
        if (root == null)
            return level;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size--;
            }
            level++;
        }

        return level;
    }

    // 非递归实现二叉树的遍历
    public static List<Integer> midOrderWithoutRecursive(TreeNode head) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
             } else {

                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

        }

        return res;

    }

    public static List<Integer> postOrderWithoutRecursive(TreeNode head) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(res);
        return res;

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        int leftDepth = getDepth(root.left);
        int rootDepth = getDepth(root.right);

        return Math.abs(leftDepth - rootDepth) > 1 ? false : true;

    }

    private static int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHigh(root.left);
        int right = getHigh(root.right);

        return Math.max(left, right) + 1;
    }

    // 计算二叉树的深度, 通过队列计算, 层序遍历
    private static int getDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = -1;
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(root.right);
                }
                size--;
            }
            depth++;
        }

        return depth;
    }




    public static void main(String[] args) {

        /**
         * 树形结构；
         *
         *               1
         *           2         3
         *       6     4    5
         *
         */

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode subNode = new TreeNode(4);
        TreeNode rightSubNode = new TreeNode(5);
        TreeNode leafNode = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.right = subNode;
        right.left = rightSubNode;
        left.left = leafNode;

//        preOrder(root);
//
//        System.out.println();
//
//        midOrder(root);
//
//        System.out.println();
//
//        postOrder(root);

        System.out.println(getHigh(root));


    }


}
