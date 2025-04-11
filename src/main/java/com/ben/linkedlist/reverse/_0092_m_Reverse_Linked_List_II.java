package com.ben.linkedlist.reverse;

import com.ben.common.ListNode;
import com.ben.common.ListNodeUtil;
import com.ben.common.PrintUtil;

public class _0092_m_Reverse_Linked_List_II {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(5, 4, 3, 2, 1);

        PrintUtil.printListNode(new Solution().reverseBetween(head, 2, 4));
    }

    static
    class Solution {

        private ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            if (head == null || head.next == null) {
                return head;
            }

            if (left > 1) {
                ListNode next = reverseBetween(head.next, left - 1, right - 1);
                head.next = next;
                return head;
            }

            if (right > 1) {
                ListNode next = head.next;
                ListNode newHeader = reverseBetween(head.next, left - 1, right - 1);
                next.next = head;
                head.next = successor;
                return newHeader;
            }

            //tail to add
            successor = head.next;
            return head;
        }
    }


    class Solution2 {

        private ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left > 1) {
                head.next = reverseBetween(head.next, left - 1, right - 1);
                return head;
            }

            return reverseFirstN(head, right);
        }

        private ListNode reverseFirstN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }

            ListNode next = head.next;
            ListNode newHeader = reverseFirstN(head.next, n - 1);
            next.next = head;
            head.next = successor;
            return newHeader;
        }
    }
}
