package leetcode.linkedList;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 15:42
 **/
public class SplitLinkedListInParts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null)
            return res;

        int listSize = size(root);
        if (listSize <= k) {
            int i = 0;
            ListNode cur = root;
            while (cur != null) {
                ListNode curNext = cur.next;
                res[i++] = cur;
                cur.next = null;
                cur = curNext;
            }
        } else {
            int everyListElem = listSize / k;
            int leftOver = listSize - everyListElem * k;
            ListNode curr = root;
            int j = 0;
            while (j < k) {
                int elementAdded = 0;
                ListNode dummy = new ListNode(-1);
                ListNode n = dummy;

                while (curr != null && elementAdded < everyListElem) {
                    n.next = curr;
                    curr = curr.next;
                    n = n. next;
                    elementAdded++;
                }
                if (leftOver > 0) {
                    n.next = curr;
                    n = n.next;
                    curr = curr.next;
                    leftOver--;
                }
                n.next = null;
                res[j++] = dummy.next;
            }
        }
        return res;
    }

    private int size(ListNode root) {
        int i = 0;
        while (root != null) {
            i++;
            root = root.next;
        }
        return i;
    }
}