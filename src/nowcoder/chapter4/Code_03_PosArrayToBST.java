package nowcoder.chapter4;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-25 21:13
 **/
public class Code_03_PosArrayToBST {
    private static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;
        return isPost(arr, 0, arr.length -1);
    }

    private static boolean isPost(int[] arr, int start, int end) {
        if (start == end)
            return true;
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i])
                less = i;
            else
                more = more == end ? i : more;
        }
        if (less == -1 || more == end)
            return isPost(arr, start, end - 1);
        if (less != more - 1)
            return false;
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node postArrayToBST(int[] postArr) {
        if (postArr == null)
            return null;
        return post2BST(postArr, 0, postArr.length - 1);
    }

    private static Node post2BST(int[] postArr, int start, int end) {
        if (start > end)
            return null;
        Node head = new Node(postArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (postArr[end] > postArr[i])
                less = i;
            else
                more = more == end ? i : more;
        }
        head.left = post2BST(postArr, start, less);
        head.right = post2BST(postArr, more, end - 1);
        return head;
    }

    private static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
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

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 6, 5, 7, 4 };
        System.out.println(isPost(arr, 0, arr.length - 1));
        printTree(postArrayToBST(arr));
    }
}
