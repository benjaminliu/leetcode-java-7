package com.ben.array.twopointer.binarysearch;

import com.ben.common.PrintUtil;

public class _0410_h_Split_Array_Largest_Sum {
    public static void main(String[] args) {
//        int[] nums = new int[]{7, 2, 5, 10, 8};
//        int k = 2;

//        int[] nums = new int[]{1, 4, 4};
//        int k = 3;

        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        int k = 2;

        PrintUtil.printLn(new Solution().splitArray(nums, k));
    }

    static
    class Solution {
        public int splitArray(int[] nums, int k) {
            int left = 0;
            int right = 0;
            for (int n : nums) {
                left = Math.max(left, n);
                right += n;
            }

            left = Math.max(left, right / k);


            while (left <= right) {
                int mid = (left + right) / 2;

                int group = 1;
                int cur = 0;

                for (int n : nums) {
                    if (cur + n > mid) {
                        group++;
                        cur = n;
                    } else {
                        cur += n;
                    }
                }

                if (group > k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }
}
