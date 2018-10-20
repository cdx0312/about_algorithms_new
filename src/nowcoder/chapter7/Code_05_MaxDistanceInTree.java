package nowcoder.chapter7;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-27 17:16
 **/
public class Code_05_MaxDistanceInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        int distance;
        int height;

        public ReturnType(int distance, int height) {
            this.distance = distance;
            this.height = height;
        }
    }

    public static ReturnType process(Node root) {
        if (root == null)
            return new ReturnType(0, 0);
        ReturnType leftReturnType = process(root.left);
        ReturnType rightReturnType = process(root.right);
        int includeHeadDistance = leftReturnType.height + rightReturnType.height + 1;
        int p1 = leftReturnType.distance;
        int p2 = rightReturnType.distance;
        int resultDistance = Math.max(Math.max(p1,p2), includeHeadDistance);
        int hitself = Math.max(leftReturnType.height, rightReturnType.height) + 1;
        return new ReturnType(resultDistance, hitself);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(process(head1).distance);

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(process(head2).distance);

    }
}
