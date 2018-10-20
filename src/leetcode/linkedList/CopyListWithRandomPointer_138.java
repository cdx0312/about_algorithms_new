package leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 16:00
 **/
public class CopyListWithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
}
