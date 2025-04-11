package com.ben.array.twopointer;

public class _0283_e_Move_Zeroes {

    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                } else {
                    nums[i - zeroCount] = nums[i];
                }
            }

            int idx = nums.length - 1;
            while (zeroCount > 0) {
                nums[idx] = 0;
                idx--;
                zeroCount--;
            }
        }
    }
}
