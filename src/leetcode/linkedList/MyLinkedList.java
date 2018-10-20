package leetcode.linkedList;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 14:49
 **/
public class MyLinkedList {
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = head.next;
        while (index > 0 && cur != tail) {
            index--;
            cur = cur.next;
        }
        return index > 0 ? -1 : cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.pre = tail.pre;
        node.pre.next = node;
        tail.pre = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node cur = head.next;
        while (index > 0 && cur != tail) {
            index--;
            cur = cur.next;
        }
        if (index > 0)
            return;
        Node node = new Node(val);
        node.pre = cur.pre;
        node.pre.next = node;
        node.next = cur;
        cur.pre = node;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0)
            return;
        Node cur = head.next;
        while (index > 0 && cur != tail){
            index--;
            cur = cur.next;
        }
        if (index > 0 || cur == tail)
            return;

        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
