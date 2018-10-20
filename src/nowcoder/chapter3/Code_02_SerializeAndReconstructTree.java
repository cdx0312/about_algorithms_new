package nowcoder.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 21:31
 **/
public class Code_02_SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private static String serialByPre(Node head) {
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    private static Node reconByPreOrder(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : values) {
            queue.offer(s);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        assert value != null;
        if (value.equals("#"))
            return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    private static String serialByLevel(Node head) {
        if (head == null)
            return "#!";
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    private static Node reconByLevelString(String levelString) {
        String[] values = levelString.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null)
            queue.offer(head);
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return head;

    }

    private static Node generateNodeByString(String value) {
        if (value.equals("#"))
            return null;
        return new Node(Integer.valueOf(value));
    }

}
