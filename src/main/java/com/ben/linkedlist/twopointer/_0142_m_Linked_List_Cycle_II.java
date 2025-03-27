package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;

public class _0142_m_Linked_List_Cycle_II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    break;
                }
            }

            if (fast == null || fast.next == null) {
                return null;
            }

            fast = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
