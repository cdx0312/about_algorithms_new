package chapter1;

import leetcode.linkedList.ListNode;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 14:13
 **/
public class C_03_RelocateLinkedList {
    private static void relocate(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode.printLinkedList(head);
        ListNode.printLinkedList(mid);
        mergeTwoLinkedList(head, mid);
    }

    private static void mergeTwoLinkedList(ListNode head, ListNode mid) {
        ListNode left = head;
        while (left.next != null) {
            ListNode tmp = left.next;
            left.next = mid;
            mid = mid.next;
            left.next.next = tmp;
            left = tmp;
        }
        left.next = mid;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4,5,6,7},7);
        ListNode.printLinkedList(head);
        relocate(head);
        ListNode.printLinkedList(head);
    }
}
