package com.ben.array.twopointer;

import com.ben.common.PrintUtil;

public class _0005_m_Longest_Palindromic_Substring {

//    Given a string s, return the longest palindromic substring in s.
//
//    Example 1:
//
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
//            Example 2:
//
//    Input: s = "cbbd"
//    Output: "bb"

    public static void main(String[] args) {
        String s = "babad";

        PrintUtil.printLn(new Solution().longestPalindrome(s));
    }

    static
    class Solution {

        private int maxLength = 0;
        private int startIdx;
        private int endIdx;

        public String longestPalindrome(String s) {

            maxLength = 0;
            startIdx = 0;
            endIdx = 0;

            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length() - 1; i++) {
                longestPalindrome(chars, i, i);
                longestPalindrome(chars, i, i + 1);
            }

            return s.substring(startIdx, endIdx + 1);
        }

        private void longestPalindrome(char[] chars, int start, int end) {
            while (start >= 0 && end < chars.length) {
                if (chars[start] == chars[end]) {
                    start--;
                    end++;
                } else {
                    break;
                }
            }
            start++;
            end--;

            int length = end - start + 1;
            if (length > maxLength) {
                maxLength = length;
                startIdx = start;
                endIdx = end;
            }
        }
    }
}
