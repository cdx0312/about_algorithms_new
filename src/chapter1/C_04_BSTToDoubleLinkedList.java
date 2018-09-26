package chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 16:48
 **/
public class C_04_BSTToDoubleLinkedList{
    // 双链表节点
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode BST2DLL(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        inorderToQueue(root, queue);
        if (queue.isEmpty())
            return root;
        root = queue.poll();
        TreeNode pre = root;
        pre.left = null;
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            assert cur != null;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return root;
    }

    private static void inorderToQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root == null)
            return;
        inorderToQueue(root.left, queue);
        queue.offer(root);
        inorderToQueue(root.right, queue);
    }

    private static void  printBSTInOrder(TreeNode root) {
        System.out.println("BST IN ORDER ");
        if (root != null)
            printBSTInOrderHelp(root);
        System.out.println();
    }

    private static void printBSTInOrderHelp(TreeNode root) {
        if (root == null)
            return;
        printBSTInOrderHelp(root.left);
        System.out.println(root.value + " ");
        printBSTInOrderHelp(root.right);
    }

    private static void printDLL(TreeNode head) {
        System.out.println("Double LinkedList");
        TreeNode end = null;
        while (head != null) {
            System.out.println(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.println("| ");
        while (end != null) {
            System.out.println(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }
}
