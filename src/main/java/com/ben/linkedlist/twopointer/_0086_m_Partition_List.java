package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;
import com.ben.common.PrintUtil;

public class _0086_m_Partition_List {

    public static void main(String[] args) {
        int x = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PrintUtil.printListNode(head);
        Solution2 solution = new Solution2();
        ListNode newHead = solution.partition(head, x);
        PrintUtil.printListNode(newHead);
    }

    /**
     * Example 1:
     * Input: head = [1,4,3,2,5,2], x = 3
     * Output: [1,2,2,4,3,5]
     * <p>
     * Example 2:
     * Input: head = [2,1], x = 2
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: head = [1,4,3,0,2,5,2] , x = 3
     * Output: [1,0,2,2,4,3,5]
     */
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode cur = dummy;

            //Find the first place bigger than/equals to X, as the place to insert
            ListNode nodeToInsertAfter = null;
            while (cur.next != null) {
                if (cur.next.val >= x) {
                    nodeToInsertAfter = cur;
                    break;
                }
                cur = cur.next;
            }

            while (cur.next != null) {
                if (cur.next.val < x) {
                    ListNode nodeToMove = removeNext(cur);
                    insertAfter(nodeToInsertAfter, nodeToMove);
                    nodeToInsertAfter = nodeToInsertAfter.next;
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }

        private ListNode removeNext(ListNode cur) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            return tmp;
        }

        private void insertAfter(ListNode nodeToInsertAfter, ListNode nodeToInsert) {
            nodeToInsert.next = nodeToInsertAfter.next;
            nodeToInsertAfter.next = nodeToInsert;
        }
    }

    static class Solution2 {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy1 = new ListNode(0);
            ListNode dummy2 = new ListNode(0);

            //All the nodes smaller than x
            ListNode p1 = dummy1;
            //Other nodes
            ListNode p2 = dummy2;

            ListNode cur = head;

            while (cur != null) {
                if (cur.val < x) {
                    p1.next = cur;
                    p1 = p1.next;
                } else {
                    p2.next = cur;
                    p2 = p2.next;
                }
                cur = cur.next;
            }

            //We have loop through the whole link, and created two links. need to break the incorrect relation of original link
            p1.next = null;
            p2.next = null;

            p1.next = dummy2.next;

            return dummy1.next;
        }

    }
}
