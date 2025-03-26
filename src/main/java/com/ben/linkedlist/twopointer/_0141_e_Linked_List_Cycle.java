package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;

public class _0141_e_Linked_List_Cycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }
}
