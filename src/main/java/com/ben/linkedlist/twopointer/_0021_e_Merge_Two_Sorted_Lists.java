package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;

public class _0021_e_Merge_Two_Sorted_Lists {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;

            if (list2 == null) return list1;

            ListNode head;
            if (list1.val <= list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }

            ListNode cur = head;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            if (list1 != null) cur.next = list1;
            if (list2 != null) cur.next = list2;

            return head;
        }
    }

    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            //Create a dummy node to avoid the head check
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if (list1 != null) cur.next = list1;
            if (list2 != null) cur.next = list2;

            return dummy.next;
        }
    }
}
