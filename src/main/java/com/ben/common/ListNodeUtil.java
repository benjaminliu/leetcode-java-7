package com.ben.common;

public class ListNodeUtil {

    public static ListNode create(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }
}
