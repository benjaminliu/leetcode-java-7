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
        Solution solution = new Solution();
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

            ListNode nodeToInsertAfter = null;
            while (cur.next != null) {
                if (cur.next.val >= x) {
                    nodeToInsertAfter = cur;
                    break;
                }
                cur = cur.next;
            }

            //Find the position of x
            while (cur.next != null) {
                if (cur.next.val == x) {
                    break;
                }
                cur = cur.next;
            }

            cur = cur.next;

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
}
