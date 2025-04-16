package com.ben.array.slidingwindow;

public class _0003_m_Longest_Substring_Without_Repeating_Characters {


    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }

            int[] map = new int[128];
            char[] chars = s.toCharArray();

            map[chars[0]]++;
            int maxLen = 1;
            int start = 0;
            for (int i = 1; i < chars.length; i++) {
                int tmp = chars[i];
                map[tmp]++;
                if (map[tmp] < 2) {
                    int len = i - start + 1;
                    maxLen = Integer.max(len, maxLen);
                } else {
                    while (map[tmp] > 1) {
                        map[chars[start]]--;
                        start++;
                    }
                }
            }

            return maxLen;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            //store the latest index of each character
            //So if a character happens twice, we will store the second index (from left to right)
            int[] map = new int[128];

            int maxLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                start = Math.max(start, map[c]);
                maxLen = Math.max(maxLen, i - start + 1);

                //update the character's index
                //Why + 1?
                // for abacd, when we meet the second a in idx(2).
                //We calculate the length for ba,   not aba.
                //so we just + 1 to exclude the duplicate a in idx 0
                map[c] = i + 1;
            }

            return maxLen;
        }
    }
}
