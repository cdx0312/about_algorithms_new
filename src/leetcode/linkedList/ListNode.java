package leetcode.linkedList;

import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }

     public static ListNode createLinkedList(int arr[], int n) {
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

     public static void printLinkedList(ListNode head) {
          ListNode cur = head;
          while (cur != null) {
               System.out.print(cur.val + " -> ");
               cur = cur.next;
          }
          System.out.println("NULL");
     }
}
