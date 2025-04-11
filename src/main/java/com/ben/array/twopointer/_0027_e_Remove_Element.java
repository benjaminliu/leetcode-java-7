package com.ben.array.twopointer;


import com.ben.common.PrintUtil;

public class _0027_e_Remove_Element {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};

        System.out.println(new Solution().removeElement(nums, 3));
    }

    static
    class Solution {
        public int removeElement(int[] nums, int val) {

            int valCount = 0;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                //left side find a val
                int leftIdx = findFirstValIdx(nums, val, left);

                int rightIdx = right;

                while (rightIdx >= 0) {
                    if (nums[rightIdx] != val) {
                        break;
                    }
                    //right side find a val
                    valCount++;
                    rightIdx--;
                }

                if (leftIdx > rightIdx) {
                    break;
                }

                swap(nums, leftIdx, rightIdx);
                valCount++;
                left = leftIdx + 1;
                right = rightIdx - 1;
            }

            return nums.length - valCount;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        private int findFirstValIdx(int[] nums, int val, int left) {
            while (left < nums.length) {
                if (nums[left] == val) {
                    return left;
                }
                left++;
            }
            return left;
        }
    }

    class Solution2 {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
