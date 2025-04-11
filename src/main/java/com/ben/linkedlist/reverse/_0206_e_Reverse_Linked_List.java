package com.ben.linkedlist.reverse;

import com.ben.common.ListNode;
import com.ben.common.PrintUtil;

public class _0206_e_Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        PrintUtil.printListNode(new Solution2().reverseList(head));
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            ListNode newHeader = reverseList(head.next);
            next.next = head;
            head.next = null;

            return newHeader;
        }
    }

    static
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode cur = head;
            ListNode next;
            ListNode pre = null;

            while (cur.next != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            cur.next = pre;

            return cur;
        }
    }
}
