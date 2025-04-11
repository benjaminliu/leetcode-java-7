package com.ben.array.twopointer.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_m_4Sum {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            long target1 = (long) target;

            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0, endI = nums.length - 3; i < endI; i++) {
                //remove duplication
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int tmpI = i + 1;
                for (int j = tmpI, endJ = nums.length - 2; j < endJ; j++) {
                    //remove duplication
                    if (j > tmpI && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;
                    //avoid overflow
                    long sum1 = nums[i] + nums[j];

                    while (left < right) {
                        //avoid overflow
                        long sum2 = sum1 + nums[left] + nums[right];

                        if (sum2 == target1) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;

                            //remove duplication
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (target1 > sum2) {
                            left++;
                            //remove duplication
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                        } else {
                            right--;
                            //remove duplication
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
