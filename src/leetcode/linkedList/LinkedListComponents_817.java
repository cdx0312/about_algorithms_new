package leetcode.linkedList;

import java.util.HashSet;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 15:30
 **/
public class LinkedListComponents_817 {
    public int numComponents(ListNode head, int[] G) {
        if (head == null)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : G)
            set.add(i);
        boolean isContinus = false;
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!isContinus) {
                    isContinus = true;
                    res++;
                }
            } else {
                if (isContinus)
                    isContinus = false;
            }
            set.remove(head.val);
            head = head.next;
        }
        return res;
    }
}