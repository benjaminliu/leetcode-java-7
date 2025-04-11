package com.ben.linkedlist;

import com.ben.common.ListNode;

import java.util.Stack;

public class _0234_e_Palindrome_Linked_List {

    class Solution {
        /**
         * Reverse the right half of LinkedList, and then compare it with left half
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            //Fast != null, means the count of nodes is odd.
            //slow is now point to the mid node,
            if (fast != null) {
                slow = slow.next;
            }

            slow = reverseLinkedList(slow);

            fast = head;
            //Now slow is the right half, fast is the left half
            while (slow != null) {
                if (fast.val != slow.val) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }

            return true;
        }

        private ListNode reverseLinkedList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            ListNode newHead = reverseLinkedList(head.next);
            next.next = head;
            head.next = null;
            return newHead;
        }
    }


    class Solution2 {
        /**
         * Use a stack to save all the values, and then pop all the values to compare to original LinkedList
         */
        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack = new Stack<>();

            ListNode cur = head;
            while (cur != null) {
                stack.push(cur.val);
                cur = cur.next;
            }

            cur = head;

            while (cur != null) {
                Integer val = stack.pop();
                if (val != cur.val) {
                    return false;
                }
                cur = cur.next;
            }
            return true;
        }
    }
}
