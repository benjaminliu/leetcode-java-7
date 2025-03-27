package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;
import com.ben.common.PrintUtil;

public class _0876_e_Middle_of_the_Linked_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        PrintUtil.printListNode(new Solution().middleNode(head));
    }

    static
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            slow = slow.next;

            return slow;
        }
    }
}
