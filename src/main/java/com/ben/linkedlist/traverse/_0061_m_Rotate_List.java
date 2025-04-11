package com.ben.linkedlist.traverse;

import com.ben.common.ListNode;

public class _0061_m_Rotate_List {

    public static void main(String[] args) {

    }

    static
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            int length = 0;

            ListNode cur = head;
            while (cur != null) {
                length++;
                cur = cur.next;
            }

            k = k % length;
            if (k == 0) {
                return head;
            }

            int count = length - k;
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            cur = dummy;
            while (count > 0) {
                count--;
                cur = cur.next;
            }
            ListNode newHead = cur.next;
            cur.next = null;

            cur = newHead;
            //find original tail
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = head;
            return newHead;
        }
    }
}
