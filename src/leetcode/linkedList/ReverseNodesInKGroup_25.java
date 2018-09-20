package leetcode.linkedList;

import java.util.Scanner;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int k = sc.nextInt();
        ListNode head = createLinkedList(arr, arr.length);
        printLinkedList(reverseKGroup(head, k));
    }

    private static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static ListNode createLinkedList(int arr[], int n) {
        if (n == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        dummy.next = head;
        while (true) {
            ListNode node = start, cur, n = node;
            start = node.next;
            for (int i = 0; i < k && n != null; i++)
                n = n.next;
            if (n == null)
                break;
            for (int i = 0; i < k - 1; i++) {
                cur = node.next;
                node.next = cur.next;
                cur.next = n.next;
                n.next = cur;
            }
        }
        return dummy.next;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}
