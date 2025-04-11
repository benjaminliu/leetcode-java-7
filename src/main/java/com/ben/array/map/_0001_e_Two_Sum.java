package com.ben.array.map;

import java.util.HashMap;
import java.util.Map;

public class _0001_e_Two_Sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(target - nums[0], 0);
            for (int i = 1; i < nums.length; i++) {

                Integer idx = map.get(nums[i]);
                if (idx != null) {
                    return new int[]{idx, i};
                }

                map.put(target - nums[i], i);
            }

            return new int[]{-1, -1};
        }
    }
}
