package com.ben.linkedlist.twopointer;

import com.ben.common.ListNode;
import com.ben.common.PrintUtil;

public class _0160_e_Intersection_of_Two_Linked_Lists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(1);
        headB.next = new ListNode(9);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(2);
        headB.next.next.next.next = new ListNode(4);

//        ListNode headB = new ListNode(3);
//        headB.next = new ListNode(2);
//        headB.next.next = new ListNode(4);

        PrintUtil.printListNode(new Solution().getIntersectionNode(headA, headB));
    }

    static
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;

            boolean fromAToB = false;
            boolean fromBToA = false;

            while (curA != null && curB != null) {
                if (curA == curB) {
                    return curA;
                }

                if (curA.next == null && !fromAToB) {
                    curA = headB;
                    fromAToB = true;
                } else {
                    curA = curA.next;
                }
                if (curB.next == null && !fromBToA) {
                    curB = headA;
                    fromBToA = true;
                } else {
                    curB = curB.next;
                }
            }
            return curA;
        }
    }


    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;

            while (curA != curB) {
                if (curA == null) {
                    curA = headB;
                } else {
                    curA = curA.next;
                }
                if (curB == null) {
                    curB = headA;
                } else {
                    curB = curB.next;
                }
            }
            return curA;
        }
    }
}
