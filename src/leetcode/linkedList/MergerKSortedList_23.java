package leetcode.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 16:16
 **/
public class MergerKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int size = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(size, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
