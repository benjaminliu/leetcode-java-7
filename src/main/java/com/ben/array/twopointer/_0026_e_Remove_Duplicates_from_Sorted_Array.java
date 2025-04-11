package com.ben.array.twopointer;

public class _0026_e_Remove_Duplicates_from_Sorted_Array {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left = 1;
            int right = 1;
            while (right < nums.length) {
                if (nums[right] == nums[right - 1]) {
                    right++;
                } else {
                    nums[left] = nums[right];
                    left++;
                    right++;
                }
            }

            return left;
        }
    }
}
