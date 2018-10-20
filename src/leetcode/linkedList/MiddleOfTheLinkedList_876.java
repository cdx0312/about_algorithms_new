package leetcode.linkedList;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 14:30
 **/
public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null)
            return slow;
        else
            return slow.next;
    }
}
