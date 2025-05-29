package com.ben.backtracking;

import com.ben.common.PrintUtil;

import java.util.*;

public class _0039_m_Combination_Sum {

    public static void main(String[] args) {
        int[] candidations = new int[]{2, 3, 6, 7};
        int target = 7;

        PrintUtil.printListOfList(new Solution().combinationSum(candidations, target));
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            Arrays.sort(candidates);

            List<List<Integer>> res = new ArrayList<>();

            backtracking(candidates, target, 0, 0, new ArrayList<>(), res);

            return res;
        }

        private void backtracking(int[] candidates, int target, int idx, int sum, List<Integer> group, List<List<Integer>> res) {
            if (sum == target) {
                res.add(new ArrayList<>(group));
                return;
            }

            if (sum > target) {
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                int cur = candidates[i];
                int tmp = sum + cur;
                if (tmp > target) {
                    break;
                }
                group.add(cur);
                backtracking(candidates, target, i, tmp, group, res);
                group.remove(group.size() - 1);
            }
        }
    }
}
