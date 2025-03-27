package com.ben.linkedlist.heap;

import com.ben.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0023_h_Merge_k_Sorted_Lists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return Integer.compare(o1.val, o2.val);
                }
            });

            for (ListNode tmp : lists) {
                if (tmp != null) {
                    heap.add(tmp);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (!heap.isEmpty()) {
                ListNode min = heap.remove();
                cur.next = min;
                cur = cur.next;
                if (min.next != null) {
                    heap.add(min.next);
                }
            }

            return dummy.next;
        }
    }
}
