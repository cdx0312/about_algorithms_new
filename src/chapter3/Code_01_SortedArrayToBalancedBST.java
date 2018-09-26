package chapter3;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 21:26
 **/
public class Code_01_SortedArrayToBalancedBST {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        printTree(generateTree(arr));
    }
    private static Node generateTree(int[] arr) {
        if (arr == null)
            return null;
        return generate(arr, 0, arr.length-1);
    }

    private static Node generate(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node head = new Node(arr[mid]);
        head.left = generate(arr, start, mid-1);
        head.right = generate(arr, mid + 1, end);
        return head;
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
