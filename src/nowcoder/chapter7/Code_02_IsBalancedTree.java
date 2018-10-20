package nowcoder.chapter7;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 18:47
 **/
public class Code_02_IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    private static int getHeight(Node head, int level, boolean[] res) {
        if (head == null)
            return level;
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0])
            return level;
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0])
            return level;
        if (Math.abs(lH - rH) > 1)
            res[0] = false;
        return Math.max(lH, rH);
    }

    public static class ReturnType {
        public int level;
        public boolean isBalance;

        public ReturnType(int level, boolean isBalance) {
            this.level = level;
            this.isBalance = isBalance;
        }
    }

    private static boolean isB(Node head) {
        return process(head, 1).isBalance;
    }

    private static ReturnType process(Node head, int level) {
        if (head == null)
            return new ReturnType(level, true);
        ReturnType leftSubTreeInfo = process(head.left, level + 1);
        if (!leftSubTreeInfo.isBalance)
            return new ReturnType(level, false);
        ReturnType rightSubTreeInfo = process(head.right, level + 1);
        if (!rightSubTreeInfo.isBalance)
            return new ReturnType(level, false);
        if (Math.abs(rightSubTreeInfo.level - leftSubTreeInfo.level) > 1)
            return new ReturnType(level, false);
        return new ReturnType(Math.max(leftSubTreeInfo.level, rightSubTreeInfo.level), true);
    }
}
