package com.ben.linkedlist.reverse;

import com.ben.common.ListNode;

public class _0025_h_Reverse_Nodes_in_k_Group {
    class Solution {
        //We count for k nodes, reverse it, and point the tail to the head of next k nodes
        public ListNode reverseKGroup(ListNode head, int k) {
            //Find the k+1 nodes, the start of next k nodes
            ListNode cur = head;
            int count = 0;
            while (cur != null && count != k) {
                cur = cur.next;
                count++;
            }

            if (count != k) {
                //No enough nodes, just return;
                return head;
            }

            ListNode next = reverseKGroup(cur, k);
            ListNode newHead = reverseFirstN(head, k);
            //After reverse, the head become the new tail
            head.next = next;
            return newHead;
        }

        private ListNode reverseFirstN(ListNode head, int n) {
            if (n == 1) {
                return head;
            }

            ListNode next = head.next;
            ListNode newHeader = reverseFirstN(head.next, n - 1);
            next.next = head;
            head.next = null;
            return newHeader;
        }
    }
}
