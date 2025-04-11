package com.ben.array.prefix;

public class _0303_e_Range_Sum_Query_Immutable {
    class NumArray {

        private int[] numSums;
        private int[] nums;

        public NumArray(int[] nums) {
            numSums = new int[nums.length];

            numSums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                numSums[i] = numSums[i - 1] + nums[i];
            }

            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            return numSums[right] - numSums[left] + nums[left];
        }
    }


    class NumArray1 {

        private int[] numSums;

        public NumArray1(int[] nums) {
            numSums = new int[nums.length];

            numSums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                numSums[i] = numSums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return numSums[right];
            }
            return numSums[right] - numSums[left - 1];
        }
    }
}
