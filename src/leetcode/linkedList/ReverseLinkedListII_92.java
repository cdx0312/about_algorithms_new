package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ReverseLinkedListII_92 {
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre= newHead;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        for (int j = 0; j < n-m; j++) {
           cur.next = next.next;
           next.next = pre.next;
           pre.next = next;
           next = cur.next;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        ListNode head = ReverseLinkedList_206.createLinkedList(arr, n);
        ReverseLinkedList_206.printLinkedList(head);
        head = reverseBetween(head, 2, 5);
        ReverseLinkedList_206.printLinkedList(head);
    }
}
