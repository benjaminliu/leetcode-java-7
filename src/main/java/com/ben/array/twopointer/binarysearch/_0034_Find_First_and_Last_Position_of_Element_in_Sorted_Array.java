package com.ben.array.twopointer.binarysearch;

import com.ben.common.PrintUtil;

public class _0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        PrintUtil.printArray(new Solution2().searchRange(nums, target));
    }

    static
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = 0;
            if (nums[left] > target) {
                return new int[]{-1, -1};
            }

            int right = nums.length - 1;
            if (nums[right] < target) {
                return new int[]{-1, -1};
            }

            int start = findFist(nums, target, left, right);
            if (start == -1) {
                return new int[]{-1, -1};
            }

            int end = findLast(nums, target, start, right);
            return new int[]{start, end};
        }

        private int findFist(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    if (mid == left || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int findLast(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    if (mid == right || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    static
    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = 0;
            if (nums[left] > target) {
                return new int[]{-1, -1};
            }

            int right = nums.length - 1;
            if (nums[right] < target) {
                return new int[]{-1, -1};
            }

            int start = findFist(nums, target);
            if (start == -1) {
                return new int[]{-1, -1};
            }

            int end = findLast(nums, target);
            return new int[]{start, end};
        }

        private int findFist(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (left < 0 || left >= nums.length) {
                return -1;
            }
            // 判断一下 nums[left] 是不是 target
            return nums[left] == target ? left : -1;
        }

        private int findLast(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (right < 0 || right >= nums.length) {
                return -1;
            }
            // 判断一下 nums[left] 是不是 target
            return nums[right] == target ? right : -1;
        }
    }
}
