package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0022_m_Generate_Parentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backtracking(res, "", 0, 0, n);
            return res;
        }

        private void backtracking(List<String> res, String s, int open, int close, int max) {
            if (s.length() == max * 2) {
                res.add(s);
                return;
            }

            if (open < max) {
                backtracking(res, s + "(", open + 1, close, max);
            }

            if (close < open) {
                backtracking(res, s + ")", open, close + 1, max);
            }
        }
    }
}
