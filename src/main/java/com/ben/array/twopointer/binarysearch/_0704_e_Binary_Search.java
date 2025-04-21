package com.ben.array.twopointer.binarysearch;

public class _0704_e_Binary_Search {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
