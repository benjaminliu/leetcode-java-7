package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;

public class _0083_e_Remove_Duplicates_from_Sorted_List {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return head;
        }
    }
}
