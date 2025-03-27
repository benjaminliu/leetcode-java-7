package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;

public class _0019_m_Remove_Nth_Node_From_End_of_List {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            while (n > 0) {
                fast = fast.next;
                n--;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dummy.next;
        }
    }
}
